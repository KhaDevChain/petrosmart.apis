-- EINVOICE
CREATE DATABASE IF NOT EXISTS petrolimex_einvoice;

USE petrolimex_einvoice;
CREATE TABLE invoices (
	uniqueId BIGINT AUTO_INCREMENT PRIMARY KEY,
    customerName varchar(45),
    companyName varchar(100) not null,
    taxCode varchar(10),
    cccd varchar(12),
    address varchar(100),
    methodPay varchar(25) not null default 'Tiền mặt',
    acNumber varchar(25),
    billNo varchar(20) not null,
    searchCode varchar(40),
    taxAuthorityCode varchar(40),
    note varchar(70),
    createdAt datetime,
    updatedAt datetime,
    transactionId BIGINT not null
);


