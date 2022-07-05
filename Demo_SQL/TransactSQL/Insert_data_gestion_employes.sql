-- INSERT DATA - GESTION EMPLOYES


-- INSERT IN "SERVICES" TABLE
INSERT INTO Services VALUES('RESHU', 'Ressources humaines');
INSERT INTO Services (CodeService, Libelle) VALUES('ACHAT', 'Achat');
INSERT INTO Services(CodeService, Libelle) VALUES('GOD', 'Dieux');

INSERT INTO Services(CodeService, Libelle)
	VALUES('LOOSE', 'Stagiaire'),('COMPTA', 'Compatbilité');

-- INSERT IN "EMPLOYES" TABLE
INSERT INTO Employes(Nom, Prenom, DateEmbauche, Salaire, CodeService) VALUES ('Vador', 'Dark', '12/09/1999', 2365.24, 'RESHU');
INSERT INTO Employes(Nom, Prenom, DateEmbauche, Salaire, CodeService) VALUES('Yoda', 'Maître', '01/02/1454', 12, 'ACHAT');
INSERT INTO Employes(Nom, Prenom, DateEmbauche, CodeChef, Salaire, CodeService) VALUES('Skywalker', 'Luke', '01/02/2005', 3,  3000, 'ACHAT');
INSERT INTO Employes(Nom, Prenom, DateEmbauche, Salaire, CodeService) VALUES('Baka', 'Chewe', '01/02/1800', DEFAULT, 'ACHAT');
INSERT INTO Employes(Nom, Prenom, DateEmbauche, CodeService, Age) VALUES('D2', 'R2', '01/02/1454', 'RESHU', 99);
INSERT INTO Employes(Nom, Prenom, CodeService) VALUES(UPPER('Norris'), UPPER('Chuck'), 'GOD');

--INSERT INTO Conges


