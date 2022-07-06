/*
Projection
*/

SELECT * FROM Employes;

SELECT Nom, Prenom, DateEmbauche FROM Employes;

SELECT Prenom FROM Employes;

SELECT distinct Prenom FROM Employes;

UPDATE Employes SET DateNaissance = '03/08/1993' WHERE CodeEmp = -6;



SELECT CodeEmp,
		UPPER(Nom) + ' ' + Prenom AS 'Identite', --ALIAS with "AS"
		-- If null 'ISNULL' -> Print 'non renseigné' - converti en CHAR
		 ISNULL(CONVERT (char, DateNaissance, 103), '<non renseigné>') [Date de naissance], -- ALIAS with the name at the end of the line
		 ISNULL(CONVERT (char, DateEmbauche, 103), '<non renseigné>') [Embauche le],
		 -- Create new selection with name 'Salaire augmente' with a calcul
		 SalaireAugmente = Salaire *2
		FROM Employes;

