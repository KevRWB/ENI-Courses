CREATE DATABASE EVAL_DB;
GO

USE EVAL_DB;

CREATE TABLE Stagiaires (
	idStagiaire INT IDENTITY(1,1) CONSTRAINT PK_Stagiaires PRIMARY KEY,
	prenom VARCHAR(30) NOT NULL,
	nom VARCHAR(30) NOT NULL,
	email VARCHAR(250) NOT NULL,
	password VARCHAR(250) NOT NULL
);

INSERT INTO Stagiaires(prenom, nom, email, password)
VALUES ('Toto', 'Dupont', 'toto@gmail.com', '1234');

SELECT * FROM Stagiaires;

UPDATE Stagiaires SET password='456' WHERE idStagiaire=1;

DELETE FROM Stagiaires WHERE idStagiaire=2;