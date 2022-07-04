-- Create table 

CREATE TABLE Employes(
	CodeEmp INT				CONSTRAINT PK_Employes PRIMARY KEY --not null not useful -> PRIMARY KEY is required  
							IDENTITY(1,1),	-- (1,1) is the default value for IDENTITY (not required to write)		
	Nom VARCHAR(20)			not null,
	Prenom CHAR(20)			not null,
	DateNaissance DATE		null,
	DateEmbauche DATE		not null CONSTRAINT DF_Employes_DateEmbauche DEFAULT getdate(),
	DateModif TIMESTAMP		null,
	Salaire NUMERIC(8,2)	not null	CONSTRAINT DF_Employes_Salaire DEFAULT 0
										CONSTRAINT CK_Employes_Salaire CHECK(Salaire >= 0),	
	CodeService CHAR(5)		not null,
	CodeChef INT			null,
	CONSTRAINT CK_Employes_VerifDate CHECK(DateNaissance is null OR DateNaissance >= DateEmbauche)
);

CREATE TABLE Services(
	CodeService CHAR(5)		not null,
	Libelle VARCHAR(30)		not null,
	CONSTRAINT PK_Services PRIMARY KEY(CodeService),
	CONSTRAINT UN_Services_Libelle UNIQUE(Libelle)
);

CREATE TABLE Conges_Mens(
	CodeEmp int					not null	CONSTRAINT PK_Conges_Mens PRIMARY KEY,				
	Annee numeric(4,0)			not null,
	Mois numeric(2,0)			not null	CONSTRAINT CK_Conges_Mens CHECK(Mois >= 1 AND Mois <=12),
	NbJoursPris numeric(2,0)	null		CONSTRAINT DF_Conges_Mens_NbJoursPris DEFAULT 0
);

CREATE TABLE Conges(
	CodeEmp int					not null CONSTRAINT PK_Conges PRIMARY KEY,				
	Annee numeric(4,0)			not null,
	NbJoursAcquis numeric(2,0)	null	CONSTRAINT Df_Employes_NbJoursAcquis DEFAULT 30
);