-- Create table 

CREATE TABLE Employes(
	CodeEmp INT,
	Nom VARCHAR(20),
	Prenom CHAR(20),
	DateNaissance DATE,
	DateEmbauche DATE,
	DateModif TIMESTAMP,
	Salaire NUMERIC(8,2),
	CodeService CHAR(5),
	CodeChef INT
);

CREATE TABLE Services(
	CodeService CHAR(5),
	Libelle VARCHAR(30)
);

CREATE TABLE Cmonges_Mens(
	CodeEmp int,
	Annee numeric(4,0),
	Mois numeric(2,0),
	NbJoursPris numeric(2,0)
);

CREATE TABLE Conges(
	CodeEmp int,
	Annee numeric(4,0),
	NbJoursAcquis numeric(2,0),
);