/*
Created		04.03.2019
Modified		06.03.2019
Project		
Model		
Company		
Author		
Version		
Database		mySQL 5 
*/


Create table Lokalita (
	nazev Varchar(50) NOT NULL,
 Primary Key (nazev)) ENGINE = MyISAM;

Create table Trasy (
	linka Varchar(50) NOT NULL,
	odkud Varchar(50) NOT NULL,
	kam Varchar(50) NOT NULL,
 Primary Key (linka)) ENGINE = MyISAM;

Create table Mezizastavka (
	nazev Varchar(50) NOT NULL,
	linka Varchar(50) NOT NULL,
 Primary Key (nazev,linka)) ENGINE = MyISAM;

Create table Jizda (
	linka Varchar(50) NOT NULL,
	spz Varchar(50) NOT NULL,
	cislo_rp Varchar(50) NOT NULL,
	cas Timestamp NOT NULL,
 Primary Key (linka,cas)) ENGINE = MyISAM;

Create table Autobus (
	spz Varchar(50) NOT NULL,
	znacka Varchar(50) NOT NULL,
 Primary Key (spz)) ENGINE = MyISAM;

Create table Znacka (
	znacka Varchar(50) NOT NULL,
 Primary Key (znacka)) ENGINE = MyISAM;

Create table Ridic (
	cislo_rp Varchar(50) NOT NULL,
	jmeno Varchar(50) NOT NULL,
	prijmeni Varchar(50) NOT NULL,
 Primary Key (cislo_rp)) ENGINE = MyISAM;

Create table Kontakt (
	hodnota Varchar(50) NOT NULL,
	typ Varchar(50) NOT NULL,
	cislo_rp Varchar(50) NOT NULL,
 Primary Key (hodnota)) ENGINE = MyISAM;

Create table TypKontaktu (
	typ Varchar(50) NOT NULL,
 Primary Key (typ)) ENGINE = MyISAM;

Create table Jizdenka (
	linka Varchar(50) NOT NULL,
	email Varchar(50),
	cas Timestamp NOT NULL,
	cislo Bigint NOT NULL AUTO_INCREMENT,
 Primary Key (cislo)) ENGINE = MyISAM;

Create table Klient (
	email Varchar(50) NOT NULL,
	jmeno Varchar(50) NOT NULL,
	prijmeni Varchar(50) NOT NULL,
 Primary Key (email)) ENGINE = MyISAM;


