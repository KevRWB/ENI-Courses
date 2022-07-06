/*
FANTASY WORLD
CREATE TABLES
*/
CREATE TABLE Heroes(
	HeroID		NUMERIC(3)		CONSTRAINT PK_Heroes_HeroNum PRIMARY KEY
								IDENTITY(0,1),
	HeroName	VARCHAR(30)		not null,
	HeroPV		NUMERIC(2)		not null,
	HeroATT		NUMERIC(2)		not null,
	HeroSPD		NUMERIC(2)		not null,
	HeroRACE	VARCHAR(30)		null
	
);

CREATE TABLE Monsters(
	MonstID		NUMERIC(3)		CONSTRAINT PK_Monsters_MonstID PRIMARY KEY not null
								IDENTITY(0,1),
	MonstName	VARCHAR(30)		not null,
	MonstPV		NUMERIC(2)		not null,
	MonstATT	NUMERIC(2)		not null,
	MonstSPD	NUMERIC(2)		not null,
	MonstRACE	VARCHAR(30)		null	
);

CREATE TABLE Weapons(
	WeapID		NUMERIC(3)		CONSTRAINT PK_Weapons_WeapID PRIMARY KEY not null
								IDENTITY(0,1),
	WeapName	VARCHAR(30)		not null,
	WeapATT		NUMERIC(2)		not null,
	WeapSPD		NUMERIC(2)		not null	
);

/*
INSERT HEROES
*/

INSERT INTO Heroes(HeroName, HeroPV, HeroATT, HeroSPD, HeroRACE)VALUES(
	'Ragnar',
	20,
	30,
	15,
	'Barbare'
);

