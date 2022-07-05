--CREATE TABLE FOR LOCATIONS DB

CREATE TABLE Clients (
	noCli NUMERIC(6) not null
		CONSTRAINT PK_Clients_noCli PRIMARY KEY,		 		
	nom VARCHAR(30) not null,
	prenom VARCHAR(30),
	adresse VARCHAR(120),
	cpo CHAR(5) not null
		CONSTRAINT CK_Clients_cpo CHECK( cpo BETWEEN '01000' AND '95999'),
	ville VARCHAR(80) not null
		CONSTRAINT DF_Clients_ville DEFAULT 'Nantes'
);

CREATE TABLE Fiches(
	noFic NUMERIC(6)
		CONSTRAINT PK_Fiches_noFic PRIMARY KEY,
	noCli	NUMERIC(6),
	dateCrea DATETIME not null,
	datePaye DATETIME, 
	etat CHAR(2) not null
		CONSTRAINT CK_Fiches_etat CHECK (etat = 'EC' OR etat = 'RE' OR etat = 'SO')
		CONSTRAINT DF_Fiches_etat DEFAULT 'EC',

	CONSTRAINT CK_Fiches_datePaye CHECK(datePaye > dateCrea AND etat = 'SO')
);

CREATE TABLE LignesFic(
	noFic NUMERIC(6),
	noLig NUMERIC(3),
	refart CHAR(8) not null,
	depart DATETIME not null
		CONSTRAINT DF_Fiches_dateCrea DEFAULT getdate(),
	retour DATETIME
		CONSTRAINT K_LignesFic PRIMARY KEY (noFic, noLig),

	CONSTRAINT CK_LignesFic_retour CHECK(retour > depart),
);

CREATE TABLE Articles(
	refart CHAR(8) not null
		CONSTRAINT PK_Articles_refart PRIMARY KEY,
	designation VARCHAR(80) not null,
	codeGam CHAR(5) not null,
	codeCate CHAR(5) not null,

);

CREATE TABLE Gammes(
	codeGam CHAR(5) not null
		CONSTRAINT PK_Gammes_codeGam PRIMARY KEY,
	libelle VARCHAR(30) not null 
		CONSTRAINT UN_Gammes_libelle UNIQUE
);

CREATE TABLE GrilleTarifs(
	codeGam CHAR(5) not null,
	codeCate CHAR(5) not null,
	codeTarif CHAR(5) not null,

	CONSTRAINT PK_GrilleTarifs PRIMARY KEY(codeGam, codeCate)
	
);

CREATE TABLE Categories(
	codeCate CHAR(5) not null
		CONSTRAINT PK_Categories_codeCate PRIMARY KEY,
	libelle VARCHAR(30) not null
		CONSTRAINT UN_Categories_libelle UNIQUE
);

CREATE TABLE Tarifs(
	codeTarif CHAR(5) not null
		CONSTRAINT PK_Tarifs_codeTarif PRIMARY KEY,
	libelle VARCHAR(30) not null,
	prixJour NUMERIC(5,2) not null
		CONSTRAINT UN_Tarifs_libelle UNIQUE
		CONSTRAINT CK_Tarifs_prisJour CHECK( prixJour > 0)
);