-- OPERATION
CREATE TABLE orders (
	uniqueId BIGINT AUTO_INCREMENT PRIMARY KEY,
    createdAt datetime default null,
    updatedAt datetime default null,
    stationId varchar(50) not null,
    stationName varchar(30) not null,
    fuelPipeId varchar(50) not null,
    indexPipe varchar(2) not null,
    fuelName varchar(20) not null,
    lit float not null,
    price float not null,
    methodPay varchar(25) default 'Tiền mặt',
    customerId varchar(50),
    customerCardId varchar(25),
    customerTax varchar(10),
    customerName varchar(45),
    idNumRef int(4),
    billNo varchar(20),
    isExported boolean default false,
    exportedAt datetime default null,
    transactionId BIGINT not null
);

ALTER TABLE orders
ADD UNIQUE INDEX index_stationId_fuelPipeId_createdAt (stationId, fuelPipeId, createdAt);


CREATE TABLE transactions (
	uniqueId BIGINT AUTO_INCREMENT PRIMARY KEY,
    billNo varchar(20),
    totalMoney float not null,
    totalLit float not null,
    customerId varchar(50),
    customerName varchar(45),
    note varchar(70),
    fastId int(1),
    vnptId int(1),
    misaId int(1),
    createdAt datetime default null,
    updatedAt datetime default null
);

ALTER TABLE transactions
ADD UNIQUE INDEX index_billNo_createdAt (billNo, createdAt)


ALTER TABLE orders
ADD CONSTRAINT fk_order_trans
FOREIGN KEY (transactionId) REFERENCES transactions(uniqueId)
ON DELETE CASCADE
ON UPDATE CASCADE;