-- OPERATION
CREATE TABLE orders (
	uniqueId BIGINT AUTO_INCREMENT PRIMARY KEY,
    createdAt datetime default null,
    updatedAt datetime default null,
    exportedAt datetime default null,
    stationId varchar(50) not null,
    stationName varchar(30) not null,
    fuelPipeId varchar(50) not null,
    indexPipe varchar(2) not null,
    fuelName varchar(20) not null,
    lit float not null,
    price float not null,
    methodPay varchar(25) default 'Tiền mặt',
    customerPhone varchar(12),
    customerCardId varchar(25),
    customerTax varchar(10),
    customerName varchar(45),
    IdNumRef int(4),
    billNo varchar(20),
    isExported boolean default false,
    transactionId varchar(50)
);

ALTER TABLE orders
ADD UNIQUE INDEX index_stationId_fuelPipeId_createdAt (stationId, fuelPipeId, createdAt);


CREATE TABLE transactions (
	uniqueId BIGINT AUTO_INCREMENT PRIMARY KEY,
    billNo varchar(20),
    totalMoney float not null,
    totalLit float not null,
    statusCode int(3),
    customerPhone varchar(12), 
    customerCardId varchar(25),
    customerTax varchar(10),
    customerName varchar(45),
    note varchar(70),
    exportedAt datetime default null,
    UNIQUE (billNo, exportedAt)
);

ALTER TABLE transactions
ADD UNIQUE INDEX index_billNo_exportedAt (billNo, exportedAt),
ADD UNIQUE INDEX index_billNo_customerTax_exportedAt (billNo, customerTax, exportedAt);
