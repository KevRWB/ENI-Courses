/*
Lister le d�tail des cong�s mensuels pris par chaque employ� en 2005. 
Les employ�s n'ayant pas pris de cong�s cette ann�e l� font partie du r�sultat
*/

-- D�sactiver IDENTITY pour g�rer le le codeEmp
SET IDENTITY_INSERT EMPLOYES ON;

INSERT INTO Employes(CodeEmp, Nom, Prenom, DateNaissance, DateEmbauche, Salaire, CodeService, CodeChef)
VALUES(-99, 'Copter', 'Lily', '24/12/1986', '24/12/2021', 4564, 'INFOR', -2 );

INSERT INTO Conges(CodeEmp, Annee, NbJoursAcquis)
VALUES(-99, 2005, DEFAULT);

SET IDENTITY_INSERT Employes OFF;

--------------------------------------------
--EXO

SELECT Nom,
	e.CodeEmp,
	c.Annee AS [Ann�e Cong�s],
	SUM(NbJoursPris) AS NbJoursPris
FROM Employes e
INNER JOIN Conges c ON c.CodeEmp = e.CodeEmp
LEFT JOIN Conges_Mens cm ON cm.CodeEmp = c.CodeEmp AND cm.Annee = c.Annee 
WHERE c.Annee = 2005 
GROUP BY Nom, e.CodeEmp, c.Annee;
;
