/*
Lister l'employé le mieux payé par service
*/

SELECT MAX(salaire) AS SalaireMax, 
	codeService
INTO #T1
FROM Employes
GROUP BY CodeService;

SELECT nom,  e.codeService, Salaire
FROM Employes e
CROSS JOIN #T1
WHERE Salaire = SalaireMax;

DROP TABLE #T1;
