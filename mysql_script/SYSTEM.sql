DELIMITER $$

CREATE PROCEDURE create_operation_database_and_copy_tables()
BEGIN
    DECLARE db_name_current VARCHAR(50);
    DECLARE db_name_next VARCHAR(50);
    DECLARE current_year INT;
    DECLARE next_year INT;
    DECLARE done INT DEFAULT FALSE;
    DECLARE table_name VARCHAR(255);
    DECLARE cur CURSOR FOR 
        SELECT table_name 
        FROM information_schema.tables 
        WHERE table_schema = db_name_current;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    -- Lấy năm hiện tại và năm tiếp theo
    SET current_year = YEAR(CURDATE());
    SET next_year = current_year + 1;

    -- Tạo tên database cho năm hiện tại và năm sau
    SET db_name_current = CONCAT('operation', current_year);
    SET db_name_next = CONCAT('operation', next_year);

    -- Tạo database cho năm sau nếu chưa tồn tại
    SET @create_db_sql = CONCAT('CREATE DATABASE IF NOT EXISTS ', db_name_next);
    PREPARE stmt FROM @create_db_sql;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;

    -- Mở con trỏ để lấy danh sách các bảng từ database của năm hiện tại
    OPEN cur;

    -- Duyệt qua các bảng và sao chép sang database mới
    read_loop: LOOP
        FETCH cur INTO table_name;
        IF done THEN
            LEAVE read_loop;
        END IF;

        -- Tạo bảng mới trong database năm sau dựa trên cấu trúc của bảng hiện tại
        SET @copy_table_sql = CONCAT('CREATE TABLE ', db_name_next, '.', table_name, ' LIKE ', db_name_current, '.', table_name);
        PREPARE stmt FROM @copy_table_sql;
        EXECUTE stmt;
        DEALLOCATE PREPARE stmt;

        -- Sao chép dữ liệu từ bảng năm hiện tại sang bảng năm sau
        SET @copy_data_sql = CONCAT('INSERT INTO ', db_name_next, '.', table_name, ' SELECT * FROM ', db_name_current, '.', table_name);
        PREPARE stmt FROM @copy_data_sql;
        EXECUTE stmt;
        DEALLOCATE PREPARE stmt;
    END LOOP;

    CLOSE cur;
END$$

DELIMITER ;



-- GỌI SỰ KIỆN

DELIMITER $$

CREATE EVENT IF NOT EXISTS copy_operation_tables_event
ON SCHEDULE
    EVERY 1 YEAR
    STARTS '2024-12-31 23:59:59'
DO
    CALL create_operation_database_and_copy_tables();
$$

DELIMITER ;


-- BẬT SỰ KIỆN

SET GLOBAL event_scheduler = ON;


