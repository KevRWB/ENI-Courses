--CREATE TABLE FOR LOCATIONS DB

CREATE TABLE Clients (
	noCli NUMERIC(6) 			CONSTRAINT PK_Clients_noCli PRIMARY KEY not null,		 		
	nom VARCHAR(30) not null,
	prenom VARCHAR(30),
	adresse VARCHAR(120),
	cpo CHAR(5) 				CONSTRAINT CK_Clients_cpo CHECK( CONVERT(NUMERIC(5), cpo) BETWEEN 1000 AND 95999 ) not null,	--Convert Char to Numeric
	ville VARCHAR(80) 			CONSTRAINT DF_Clients_ville DEFAULT 'Nantes' not null
);

CREATE TABLE Fiches(
	noFic NUMERIC(6)			CONSTRAINT PK_Fiches_noFic PRIMARY KEY,
	noCli	NUMERIC(6),
	dateCrea DATETIME			CONSTRAINT DF_Fiches_dateCrea DEFAULT GETDATE() not null ,
	datePaye DATETIME, 
	etat CHAR(2) 				CONSTRAINT CK_Fiches_etat CHECK (etat = 'EC' OR etat = 'RE' OR etat = 'SO') -- (etat IN('EC', 'RE', 'SO')
								CONSTRAINT DF_Fiches_etat DEFAULT 'EC' not null,

	CONSTRAINT CK_Fiches_VerifDate CHECK(datePaye is null OR datePaye > dateCrea),
	CONSTRAINT CK_FIches_datePaye_etat CHECK((etat = 'SO' AND datePaye is not null) OR (datePaye is null AND etat !='SO'))

);

CREATE TABLE LignesFic(
	noFic NUMERIC(6),
	noLig NUMERIC(3),
	refart CHAR(8) not null,
	depart DATETIME not null,
	retour DATETIME,				
	
	CONSTRAINT PK_LignesFic PRIMARY KEY (noFic, noLig),		-- PRIMARY KEY multiple
	CONSTRAINT CK_LignesFic_retour CHECK(retour > depart),
);

CREATE TABLE Articles(
	refart CHAR(8) not null		CONSTRAINT PK_Articles_refart PRIMARY KEY,
	designation VARCHAR(80) not null,
	codeGam CHAR(5) not null,
	codeCate CHAR(5) not null,

);

CREATE TABLE Gammes(
	codeGam CHAR(5) 		CONSTRAINT PK_Gammes_codeGam PRIMARY KEY not null,
	libelle VARCHAR(30)		CONSTRAINT UN_Gammes_libelle UNIQUE not null
);

CREATE TABLE GrilleTarifs(
	codeGam CHAR(5) not null,
	codeCate CHAR(5) not null,
	codeTarif CHAR(5) not null,

	CONSTRAINT PK_GrilleTarifs PRIMARY KEY(codeGam, codeCate)
	
);

CREATE TABLE Categories(
	codeCate CHAR(5) 				CONSTRAINT PK_Categories_codeCate PRIMARY KEY not null,
	libelle VARCHAR(30)				CONSTRAINT UN_Categories_libelle UNIQUE not null
);

CREATE TABLE Tarifs(
	codeTarif CHAR(5)				CONSTRAINT PK_Tarifs_codeTarif PRIMARY KEY not null,
	libelle VARCHAR(30) not null,
	prixJour NUMERIC(5,2) not null	CONSTRAINT UN_Tarifs_libelle UNIQUE
									CONSTRAINT CK_Tarifs_prisJour CHECK( prixJour > 0)
);