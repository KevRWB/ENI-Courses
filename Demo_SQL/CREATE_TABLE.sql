-- Create table 

CREATE TABLE Employes(
	CodeEmp INT				not null CONSTRAINT PK_Employes PRIMARY KEY,			
	Nom VARCHAR(20)			not null,
	Prenom CHAR(20)			not null,
	DateNaissance DATE		null,
	DateEmbauche DATE		not null CONSTRAINT DF_Employes_DateEmbauche DEFAULT getdate(),
	DateModif TIMESTAMP		null,
	Salaire NUMERIC(8,2)	not null CONSTRAINT DF_Employes_Salaire DEFAULT 0,	
	CodeService CHAR(5)		not null,
	CodeChef INT			null
);

CREATE TABLE Services(
	CodeService CHAR(5)		not null,
	Libelle VARCHAR(30)		not null,
	CONSTRAINT PK_Services PRIMARY KEY(CodeService)
);

CREATE TABLE Conges_Mens(
	CodeEmp int					not null CONSTRAINT PK_Conges_Mens PRIMARY KEY,				
	Annee numeric(4,0)			not null,
	Mois numeric(2,0)			not null,
	NbJoursPris numeric(2,0)	null CONSTRAINT DF_Employes_NbJoursPris DEFAULT 0
);

CREATE TABLE Conges(
	CodeEmp int					not null,				
	Annee numeric(4,0)			not null,
	NbJoursAcquis numeric(2,0)	null CONSTRAINT Df_Employes_NbJoursAcquis DEFAULT 30,
	CONSTRAINT PK_Conges PRIMARY KEY (CodeEmp)
);