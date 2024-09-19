-- EINVOICE
CREATE DATABASE IF NOT EXISTS petrolimex_einvoice;

USE petrolimex_einvoice;
CREATE TABLE methodExports (
	uniqueId varchar(5) primary key not null,
    methodName varchar(25) NOT NULL
);


