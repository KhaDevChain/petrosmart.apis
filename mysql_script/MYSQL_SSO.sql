-- SSO
CREATE DATABASE IF NOT EXISTS petrolimex_sso;
USE petrolimex_sso;
-- ROLE
CREATE TABLE roles (
	uniqueId varchar(50) primary key not null,
    roleName varchar(70) UNIQUE NOT NULL,
    rankest int NOT NULL DEFAULT 1,
    rankOrther float,
    createdAt datetime
);

ALTER TABLE roles
ADD UNIQUE INDEX index_rolename_rankest (roleName, rankest),
ADD UNIQUE INDEX index_rolename_rankest_rankOrther (roleName, rankest, rankOrther);



-- PERMISSION
CREATE TABLE permissions (
	uniqueId varchar(50) primary key not null,
    groupName varchar(20) unique not null,
    groupPermission varchar(300) not null,
    `description` varchar(20),
    createdAt datetime,
    activated boolean default false,
    roleId varchar(50) not null,
    UNIQUE KEY `group_name_permission` (groupName, groupPermission)
);

-- FOREIGN KEY ROLE + PERMISSION
ALTER TABLE permissions
ADD CONSTRAINT fk_role_permission 
FOREIGN KEY (roleId) REFERENCES roles(uniqueId)
ON DELETE CASCADE
ON UPDATE CASCADE;


-- chain
CREATE TABLE chains (
	uniqueId varchar(50) primary key not null,
    SKU varchar(21) not null unique,
    chainName varchar(30) unique not null,
    director varchar(40),
    createdAt datetime,
    activated boolean default false
);

ALTER TABLE chains
ADD UNIQUE INDEX index_sku_chainName (SKU, chainName),
ADD UNIQUE INDEX index_sku_chainName_director (SKU, chainName, director);

-- STATION
CREATE TABLE stations (
	uniqueId varchar(50) primary key not null,
    SKU varchar(15) not null unique,
    stationName varchar(30) unique not null,
    `address` varchar(120) not null,
    hotline varchar(13),
    tax varchar(10) NOT NULL,
    chainId varchar(50) NOT NULL,
    partnerEInvoiceId varchar(4) not null,
    createdAt datetime,
    activated boolean default false
);

ALTER TABLE stations
ADD UNIQUE INDEX index_stationName_tax (stationName, tax),
ADD UNIQUE INDEX index_stationName_tax_address (stationName, tax, sku);


-- FOREIGN KEY chain + STATION
ALTER TABLE stations
ADD CONSTRAINT fk_station_chain
FOREIGN KEY (chainId) REFERENCES chains(uniqueId)
ON DELETE CASCADE
ON UPDATE CASCADE;


-- EMPLOYEE
CREATE TABLE employees (
	uniqueId varchar(50) primary key not null,
    SKU varchar(21) not null unique,
    email varchar(35) not null unique,
    fullName varchar(50) not null,
    `password` varchar(256) not null,
    `address` varchar(100) ,
    createdAt datetime,
    activated boolean default false,
    chainId varchar(50) not null,
    stationId varchar(50) not null,
    roleId varchar(50) not null
);

ALTER TABLE employees
ADD UNIQUE INDEX index_sku_email (SKU, email);

-- FOREIGN KEY EMPLOYEE + chain + STATION + ROLE
ALTER TABLE employees
ADD CONSTRAINT fk_employee_chain
FOREIGN KEY (chainId) REFERENCES chains(uniqueId)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE employees
ADD CONSTRAINT fk_employee_station
FOREIGN KEY (stationId) REFERENCES stations(uniqueId)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE employees
ADD CONSTRAINT fk_employee_role
FOREIGN KEY (roleId) REFERENCES roles(uniqueId)
ON DELETE CASCADE
ON UPDATE CASCADE;

-- FUEL
CREATE TABLE fuels (
	uniqueId varchar(50) primary key not null,
    SKU varchar(15) not null unique,
	fuelName varchar(20) unique not null,
    activated bool default false,
    createdAt datetime,
    UNIQUE(SKU, fuelName)
);

-- FUEL TANK
CREATE TABLE fueltanks (
	uniqueId varchar(50) primary key not null,
    sku varchar(4) not null,
    maximunLit float not null,
    currentLit float not null,
    createdAt datetime,
    fuelId varchar(50) not null,
    stationId varchar(50) not null,
    UNIQUE(sku, fuelId, stationId)
);

ALTER TABLE fueltanks
ADD CONSTRAINT fk_fueltanks_fuel
FOREIGN KEY (fuelId) REFERENCES fuels(uniqueId)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE fueltanks
ADD CONSTRAINT fk_fueltanks_station
FOREIGN KEY (stationId) REFERENCES stations(uniqueId)
ON DELETE CASCADE
ON UPDATE CASCADE;


-- FUEL PRICES
CREATE TABLE fuelprices (
	uniqueId varchar(50) primary key not null,
    price float not null,
    createdAt datetime,
    timeAt varchar(10),
    fuelId varchar(50) not null
);

ALTER TABLE fuelprices
ADD CONSTRAINT fk_fuelprices_fuel
FOREIGN KEY (fuelId) REFERENCES fuels(uniqueId)
ON DELETE CASCADE
ON UPDATE CASCADE;

CREATE TABLE fuelrectangulars (
	uniqueId varchar(50) primary key not null,
    totalAClock varchar(9) not null,
    totalBClock varchar(9) not null,
    numberPipe int(1) not null,
    createdAt datetime,
    activated boolean default false
);

ALTER TABLE fuelrectangulars
ADD UNIQUE INDEX index_totalAClock_totalBClock (totalAClock, totalBClock),
ADD UNIQUE INDEX index_unique_totalAClock_totalBClock (uniqueId, totalAClock, totalBClock);

CREATE TABLE fuelpipes (
	uniqueId varchar(50) primary key not null,
    indexPipe varchar(2) not null,
    createdAt datetime,
    activated boolean default false,
    method varchar(5) not null, -- phương thức xuất hóa đơn
    fuelName varchar(20) not null,
    fuelTankId varchar(50) not null,
    fuelRectangularId varchar(50) not null
);

ALTER TABLE fuelpipes
ADD CONSTRAINT fk_fuelpipes_fueltank
FOREIGN KEY (fuelTankId) REFERENCES fueltanks(uniqueId)
ON DELETE CASCADE
ON UPDATE CASCADE;

ALTER TABLE fuelpipes
ADD CONSTRAINT fk_fuelpipes_fuelrectanglar
FOREIGN KEY (fuelRectangularId) REFERENCES fuelrectangulars(uniqueId)
ON DELETE CASCADE
ON UPDATE CASCADE;

CREATE TABLE suppliers (
	uniqueId varchar(50) primary key not null,
    SKU varchar(21) not null unique,
    supplierName varchar(150) not null,
    phone varchar(15),
    email varchar(30),
    tax varchar(10) NOT NULL,
    fuels varchar(255),
    createdAt datetime,
    activated boolean default false,
    
    UNIQUE (SKU, supplierName)
);

CREATE TABLE shiftChanges (
	uniqueId varchar(50) primary key not null,
    fromTime varchar(12) not null,
    toTime varchar(12) not null,
    createdAt datetime
);

CREATE TABLE customers (
	uniqueId varchar(50) primary key not null,
    SKU varchar(21) not null unique,
    customerName varchar(45) not null,
    phone varchar(12) not null unique,
    `address` varchar(100),
    tax varchar(10),
    cccd varchar(12),
    acNumber varchar(25),
    cardId varchar(50),
    activated boolean default false,
    createdAt datetime,
    UNIQUE KEY `index_sku_phone_customer` (SKU, phone),
    UNIQUE KEY `index_sku_phone_name_customer` (SKU, customerName, phone)
);
