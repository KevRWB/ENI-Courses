-- ALTER TABLE COURSE

-- Ajoute une colonne dans la table
ALTER TABLE Employes
	ADD Gender VARCHAR(1) not null;

--Modifie le type de la colonne
ALTER TABLE Employes
	ALTER COLUMN Gender VARCHAR(2) null;

-- Supprime la colonne 
ALTER TABLE Employes
	DROP COLUMN Gender;

-- Modifie le type de la colonne
ALTER TABLE Employes
	ALTER COLUMN Prenom VARCHAR(50) not null;

ALTER TABLE Employes
	ADD Age TINYINT;

-- CHANGE CONSTRAINTS

ALTER TABLE Employes
	ADD CONSTRAINT CK_Employes_Age CHECK(Age BETWEEN 18 AND 150);

ALTER TABLE Employes
	ADD CONSTRAINT CK_Employes_SalaireMax CHECK(Salaire < 9999);

ALTER TABLE Employes
	NOCHECK CONSTRAINT CK_Employes_SalaireMax; -- Desactive la contrainte 

ALTER TABLE Employes
	CHECK CONSTRAINT CK_Employes_SalaireMax;	-- Active la contrainte

	
ALTER TABLE Employes
	DROP CONSTRAINT CK_Employes_SalaireMax;