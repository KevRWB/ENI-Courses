--UPDATE DATA SQL

UPDATE Employes SET Nom = UPPER(nom);

UPDATE Employes SET Salaire = Salaire * 0.1 WHERE Nom = 'NORRIS';

UPDATE Employes SET Nom = LOWER(Nom), 
					Prenom = UPPER(Prenom),
					DateEmbauche = DEFAULT,
					DateNaissance = NULL;

UPDATE Employes SET CodeService = 'LOOSE' WHERE Prenom = 'Luke';

