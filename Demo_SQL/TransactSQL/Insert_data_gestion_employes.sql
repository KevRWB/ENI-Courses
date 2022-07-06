-- INSERT DATA - GESTION EMPLOYES

ALTER TABLE Employes DROP
	CONSTRAINT CK_Employes_VerifDate;

-- INSERT IN "SERVICES" TABLE
INSERT INTO Services VALUES('RESHU', 'Ressources humaines');
INSERT INTO Services (CodeService, Libelle) VALUES('ACHAT', 'Achat');
INSERT INTO Services(CodeService, Libelle) VALUES('GOD', 'Dieux');

INSERT INTO Services(CodeService, Libelle)
	VALUES('LOOSE', 'Stagiaire'),('COMPT', 'Compatbilité');

-- INSERT IN "EMPLOYES" TABLE
INSERT INTO Employes(Nom, Prenom, DateEmbauche, Salaire, CodeService) VALUES ('Vador', 'Dark', '12/09/1999', 2365.24, 'RESHU');
INSERT INTO Employes(Nom, Prenom, DateEmbauche, Salaire, CodeService) VALUES('Yoda', 'Maître', '01/02/1454', 12, 'ACHAT');
INSERT INTO Employes(Nom, Prenom, DateEmbauche, CodeChef, Salaire, CodeService) VALUES('Skywalker', 'Luke', '01/02/2005', 3,  3000, 'ACHAT');
INSERT INTO Employes(Nom, Prenom, DateEmbauche, Salaire, CodeService) VALUES('Baka', 'Chewe', '01/02/1800', DEFAULT, 'ACHAT');
INSERT INTO Employes(Nom, Prenom, DateEmbauche, CodeService, Age) VALUES('D2', 'R2', '01/02/1454', 'RESHU', 99);
INSERT INTO Employes(Nom, Prenom, CodeService) VALUES(UPPER('Norris'), UPPER('Chuck'), 'GOD');
INSERT INTO Employes(Nom, Prenom, CodeService, DateNaissance, DateEmbauche) VALUES('Dupont','Roger', 'ACHAT', '02/02/1234', '02/03/2020'); 

--UPDATES
UPDATE Employes SET DateNaissance = DATEADD(year, -65, GETDATE()) WHERE CodeService = 'ACHAT';


--DELETE Employes de plus de 65 ans

DELETE FROM Employes WHERE(  (DATEDIFF(YEAR, DateNaissance , GETDATE() )  > 63 )   ) ;


