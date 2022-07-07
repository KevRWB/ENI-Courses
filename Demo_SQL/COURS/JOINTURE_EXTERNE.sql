/*
JOINTURES EXTERNE - OUTER JOIN
*/

/*
SELECT  * FROM Services s
INNER JOIN Employes e ON e.CodeService = s.CodeService;
*/
/*
SELECT * FROM Services s
LEFT JOIN Employes e ON s.CodeService = e.CodeService;
*/

/*
SELECT s.CodeService,
	Libelle,
	COUNT(codeEmp) AS nbEmployes  
FROM Services s
LEFT JOIN Employes e ON s.CodeService = e.CodeService
GROUP BY s.CodeService, Libelle;
*/

SELECT s.CodeService,
	Libelle,
	COUNT(codeEmp) AS nbEmployes  
FROM Employes e
RIGHT JOIN Services s ON s.CodeService = e.CodeService
GROUP BY s.CodeService, Libelle;


