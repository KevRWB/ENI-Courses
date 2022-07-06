/*
MAJ DATA LOCATIONS
*/

BEGIN TRAN MAJ_DATA_LOC;

-- INSERT VALUES
INSERT INTO Gammes
	VALUES('EG', 'Entrée de gamme');
INSERT INTO Gammes
	VALUES('HG', 'Haut de gamme');
INSERT INTO Gammes
	VALUES('PR', 'Matériel Professionnel');

INSERT INTO Tarifs
	VALUES('T1', 'Base', 10);
INSERT INTO Tarifs
	VALUES('T4', 'Argent', 30);
INSERT INTO Tarifs
	VALUES('T6', 'Platine', 90);


INSERT INTO Categories
	VALUES('FOA', 'Ski de fond alternatif');
INSERT INTO Categories
	VALUES('FOP', 'Ski de fond patineur');

INSERT INTO GrilleTarifs
	VALUES('EG', 'FOA', 'T1');
INSERT INTO GrilleTarifs
	VALUES('HG', 'FOP', 'T4');
INSERT INTO GrilleTarifs
	VALUES('PR', 'FOP', 'T6');

INSERT INTO Articles
	VALUES('F05', 'Fisher Cruiser', 'EG', 'FOA');
INSERT INTO Articles
	VALUES('F50', 'Fischer SOSSkating VASA', 'HG', 'FOP');
INSERT INTO Articles
	VALUES('F60', 'Fischer RCS CARBOLITE Skating', 'PR', 'FOP');

INSERT INTO Clients(noCli, nom, prenom, adresse, cpo, ville )
	VALUES(14,'Boutaud', 'Sabine', 'Rue des platanes', 75002, 'Paris');

INSERT INTO Fiches(noFic, noCli, dateCrea, datePaye, etat)
	VALUES(1001, 14, (GETDATE()-15), (GETDATE()-13), 'SO');

INSERT INTO LignesFic(noFic, noLig, refart, depart, retour)
	VALUES(1001, 1, 'F05', (GETDATE()-15), (GETDATE()-13));
INSERT INTO LignesFic(noFic, noLig, refart, depart, retour)
	VALUES(1001, 2, 'F50', (GETDATE()-15), (GETDATE()-14));
INSERT INTO LignesFic(noFic, noLig, refart, depart, retour)
	VALUES(1001, 3, 'F60', (GETDATE()-13), (DATEADD(HOUR, 6, GETDATE()-13)));





/*ROLLBACK AND SAVES*/

--ROLLBACK TRAN MAJ_DATA_LOC;

--COMMIT TRAN MAJ_DATA_LOC;