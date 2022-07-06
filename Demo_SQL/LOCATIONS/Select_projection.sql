/*
Projection
*/

SELECT * FROM Employes;

SELECT Nom, Prenom, DateEmbauche FROM Employes;

SELECT Prenom FROM Employes;

SELECT distinct Prenom FROM Employes;

SELECT CodeEmp,
		UPPER(Nom) + ' ' + Prenom AS identite,
		 ISNULL(CONVERT (char, DateNaissance), '<non renseigné>')
		FROM Employes;