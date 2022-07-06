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
SELECT s.CodeService, libelle, nom, prenom, c.Annee, c.NbJoursAcquis, cm.mois, cm.NbJoursPris
FROM Services s
INNER JOIN Employes e ON e.codeService = s.codeService
INNER JOIN Conges c ON c.codeEmp = e.codeEmp
INNER JOIN Conges_Mens cm ON cm.CodeEmp = c.codeEmp AND cm.Annee = c.Annee;