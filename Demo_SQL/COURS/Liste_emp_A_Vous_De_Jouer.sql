/*
Lister employés ayant pris des congés en 2006 et à qui il restait plus de 10 jours de congés à prendre à la fin de l'année
*/

SELECT DISTINCT cm.CodeEmp,
    e.Nom,
    e.Prenom
FROM Conges_Mens cm
INNER JOIN Employes e ON e.CodeEmp = cm.CodeEmp
INNER JOIN Conges c ON c.CodeEmp = cm.CodeEmp AND c.Annee = cm.Annee
WHERE cm.Annee = 2006 AND cm.NbJoursPris != 0 AND (NbJoursAcquis - NbJoursPris) > 10;
----------------------------
/* CORRECTION*/
SELECT DISTINCT Nom, 
    Prenom, 
    c.Annee, 
    NbJoursAcquis,
    SUM(cm.NbJoursPris) AS [Total Jours pris],
    c.nbJoursAcquis -  SUM(cm.NbJoursPris) AS [nb Jours Restant]
FROM Employes e
INNER JOIN Conges c ON c.CodeEmp = e.CodeEmp
INNER JOIN Conges_Mens cm ON cm.CodeEmp = c.CodeEmp AND cm.Annee = c.Annee
WHERE c.Annee = 2006
GROUP BY Nom, Prenom, c.Annee, NbJoursAcquis
HAVING  (c.nbJoursAcquis -  SUM(cm.NbJoursPris)) > 10;


-----------------------------
/*
Lister détail des congés mensuels pris par chaque employé en 2005.
 Employés n'ayant pas pris de congés cette année là font partie du résultat
*/
SELECT cm.CodeEmp,
    Annee AS [Année Congés],
    Mois,
    NbJoursPris
FROM Conges_Mens cm
FULL OUTER JOIN Employes e ON e.CodeEmp = cm.CodeEmp
WHERE cm.Annee = 2006;
