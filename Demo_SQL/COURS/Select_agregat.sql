/*
SELECT AGREGAT
*/
SELECT * FROM Employes;

SELECT DISTINCT Prenom FROM Employes;

SELECT Prenom FROM Employes GROUP BY Prenom;

SELECT COUNT(*) AS [Nombre Employes] FROM Employes;

SELECT COUNT(CodeChef) AS[nb Employes avec Chef] FROM Employes;

SELECT codeService, 
    COUNT(*) AS [Nombre Employes],
    COUNT(CodeChef) AS[nb Employes avec Chef],
    SUM(Salaire) AS [masseSalariale],
    AVG(Salaire) AS [Avg Salaires],
    MIN(Salaire) AS [Salaire min],
    ROUND(MAX(Salaire), 2)  AS [Salaire max]
 FROM Employes
 WHERE UPPER(RTRIM(CodeService)) IN ('RESHU', 'INFOR') 
 GROUP BY CodeService
 HAVING SUM(Salaire) > 6000;
---------------------------------------------
SELECT DATEPART(YEAR, DateEmbauche) AS [Année Embauche] 
FROM  Employes;
--------------------------------------------
 SELECT DATEPART(YEAR, DateEmbauche) AS [Année Embauche], 
    COUNT(*) AS [Nombre Employes],
    COUNT(CodeChef) AS[nb Employes avec Chef],
    SUM(Salaire) AS [masseSalariale],
    AVG(Salaire) AS [Avg Salaires],
    MIN(Salaire) AS [Salaire min],
    ROUND(MAX(Salaire), 2)  AS [Salaire max]
 FROM Employes
 WHERE UPPER(RTRIM(CodeService)) IN ('RESHU', 'INFOR') 
 GROUP BY DATEPART(YEAR, DateEmbauche)
 ORDER BY([Année Embauche]) DESC 
;

-------------------------------------------------------
SELECT codeService, nom, prenom
FROM Employes
ORDER BY CodeService, nom;