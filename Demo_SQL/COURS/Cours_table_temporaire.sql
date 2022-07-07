/*
TABLE TEMPORAIRE
*/

SELECT AVG(salaire) AS Moyenne 
INTO #T1 --##T1 -> Accessible par toutes les requêtes
FROM Employes;

SELECT * FROM #T1;

SELECT * 
FROM Employes
CROSS JOIN #T1
WHERE Salaire > moyenne;

DROP TABLE #T1;