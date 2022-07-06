/*
SELECT JOINTURES
*/

SELECT Services.CodeService, libelle, nom, prenom
FROM Services
INNER JOIN Employes ON Employes.codeService = Services.codeService
ORDER BY CodeService;

------------------------------ WITH ALIAS FOR TABLES
SELECT s.CodeService, libelle, nom, prenom
FROM Services s
INNER JOIN Employes e ON e.codeService = s.codeService;

----------------------------------------
SELECT s.CodeService, 
    libelle, 
    nom, 
    prenom, 
    c.Annee AS [Année Congés], 
    c.NbJoursAcquis, 
    cm.mois AS[Mois de congés], 
    cm.NbJoursPris
FROM Services s
INNER JOIN Employes e ON e.codeService = s.codeService
INNER JOIN Conges c ON c.codeEmp = e.codeEmp
INNER JOIN Conges_Mens cm ON cm.CodeEmp = c.codeEmp AND cm.Annee = c.Annee

WHERE c.Annee = 2006;

-------------------------------------
SELECT e.Nom,
    e.Prenom,
    s.CodeService,
    s.Libelle
FROM Employes e 
INNER JOIN Services s ON s.CodeService = e.CodeService
ORDER BY Nom;