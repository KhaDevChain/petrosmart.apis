-- SSO
CREATE DATABASE petrolimex_sso;

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
    groupName varchar(500) unique not null,
    groupPermission varchar(3000),
    `Description` varchar(30),
    createdAt datetime,
    roleId varchar(50) not null
);

-- FOREIGN KEY ROLE + PERMISSION
ALTER TABLE permissions
ADD CONSTRAINT fk_role_permission 
FOREIGN KEY (roleId) REFERENCES roles(uniqueId)
ON DELETE CASCADE
ON UPDATE CASCADE;


-- SUPPLIER
CREATE TABLE suppliers (
	uniqueId varchar(50) primary key not null,
    SKU varchar(50) not null unique,
    supplierName varchar(70) unique not null,
    director varchar(70),
    createdAt datetime
);

ALTER TABLE suppliers
ADD UNIQUE INDEX index_sku_supplierName (SKU, supplierName),
ADD UNIQUE INDEX index_sku_supplierName_director (SKU, supplierName, director);

-- STATION
CREATE TABLE stations (
	uniqueId varchar(50) primary key not null,
    stationName varchar(70) unique not null,
    address varchar(255) not null,
    hotline varchar(15),
    tax varchar(10) NOT NULL,
    supplierId varchar(50) NOT NULL,
    createdAt datetime
);

ALTER TABLE stations
ADD UNIQUE INDEX index_stationName_tax (stationName, tax),
ADD UNIQUE INDEX index_stationName_tax_address (stationName, tax, address);


-- FOREIGN KEY SUPPLIER + STATION
ALTER TABLE stations
ADD CONSTRAINT fk_station_supplier
FOREIGN KEY (supplierId) REFERENCES suppliers(uniqueId)
ON DELETE CASCADE
ON UPDATE CASCADE;


-- EMPLOYEE
CREATE TABLE employees (
	uniqueId varchar(50) primary key not null,
    SKU varchar(50) not null unique,
    email varchar(70),
    `password` varchar(255) not null,
    address varchar(100) ,
    createdAt datetime,
    supplierId varchar(50) not null,
    stationId varchar(50),
    roleId varchar(50) not null
);

ALTER TABLE employees
ADD UNIQUE INDEX index_sku_email (SKU, email);

-- FOREIGN KEY EMPLOYEE + SUPPLIER + STATION + ROLE
ALTER TABLE employees
ADD CONSTRAINT fk_employee_supplier
FOREIGN KEY (supplierId) REFERENCES suppliers(uniqueId)
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
	fuelName varchar(50) unique not null,
    activated bool,
    createdAt datetime
);

-- FUEL TANK
CREATE TABLE fueltanks (
	uniqueId varchar(50) primary key not null,
    indexTank varchar(3) not null,
    totalLit float not null,
    restLit float not null,
    createdAt datetime,
    fuelId varchar(50) not null,
    stationId varchar(50) not null,
    UNIQUE(indexTank, fuelId, stationId)
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
    createdAt varchar(10) not null,
    timeAt varchar(10) not null,
    price float not null,
    fuelId varchar(50) not null
);

ALTER TABLE fuelprices
ADD CONSTRAINT fk_fuelprices_fuel
FOREIGN KEY (fuelId) REFERENCES fuels(uniqueId)
ON DELETE CASCADE
ON UPDATE CASCADE;



