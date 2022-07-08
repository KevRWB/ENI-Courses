/*
TP 6 - SELECT
*/

-------------------
/*
a- Liste des clients dont le nom commence par "D"
*/
/*
SELECT *
FROM clients
WHERE SUBSTRING(nom, 1,1) ='d';
*/
SELECT *
FROM clients
WHERE nom LIKE('d%');
---------------------
/*
c- Liste des fiches(n°, état) pour les clients(nom,prénom) qui habitent 44
*/

SELECT noFic,
    etat,
    nom,
    prenom
FROM fiches f
INNER JOIN  clients c ON c.noCli = f.noCli
WHERE cpo LIKE('44%');
-------------------------
/*
d-  
*/
-----
UPDATE lignesFic 
SET retour = GETDATE()
WHERE retour IS NULL;
-----
UPDATE lignesFic
SET retour = NULL
WHERE retour = GETDATE();
--------------
SELECT  f.noFic AS [Fiche N°],
    nom,
    prenom,
    lf.refart AS [Référence],
    designation,
    depart,
    retour,
    prixJour,
    ((DATEDIFF(DAY, depart, (ISNULL(retour, GETDATE())))) * prixJour) AS Montant

FROM fiches f 
INNER JOIN lignesFic lf ON lf.noFic = f.noFic
INNER JOIN clients c ON c.noCli = f.noCli
INNER JOIN articles a ON a.refart = lf.refart
INNER JOIN  grilleTarifs gt ON gt.codeCate = a.codeCate AND gt.codeGam = a.codeGam
INNER JOIN tarifs t ON t.codeTarif = gt.codeTarif
WHERE f.noFic = 1002;

--------------------------------------------
/*
e- Prix journalier moyen de location par gamme
Gamme - Tarif moyen
*/


/*
f - Liste des articles qui ont été loués au moins trois fois
*/
SELECT lf.refart AS [Référence],
    designation AS[Désignation],
    COUNT(lf.refart) AS [nbLoc]
FROM lignesFic lf
INNER JOIN articles a ON a.refart = lf.refart
GROUP BY lf.refart, designation;
--HAVING COUNT(lf.refart) >= 3; 

-------------------------------------------
/*
g - Détail de la fiche 1002 avec le total
*/
SELECT  f.noFic AS [Fiche N°],
    nom,
    prenom,
    lf.refart AS [Référence],
    designation,
    depart,
    retour,
    prixJour,
    (   ((DATEDIFF(DAY, depart, (ISNULL(retour, GETDATE()))))+1)   * prixJour) AS Montant
INTO #T1
FROM fiches f 
INNER JOIN lignesFic lf ON lf.noFic = f.noFic
INNER JOIN clients c ON c.noCli = f.noCli
INNER JOIN articles a ON a.refart = lf.refart
INNER JOIN  grilleTarifs gt ON gt.codeCate = a.codeCate AND gt.codeGam = a.codeGam
INNER JOIN tarifs t ON t.codeTarif = gt.codeTarif
WHERE f.noFic = 1002;
----
SELECT SUM(MONTANT) AS Total
INTO #T2
FROM #T1;

----
SELECT [Fiche N°],
    nom,
    prenom,
    [Référence],
    designation,
    depart,
    retour,
    prixJour,
    Montant, 
    Total
FROM #T1
CROSS JOIN #T2 ;
----
-----
DROP TABLE #T1;
DROP TABLE #T2;
-----
/*
i- Liste des locations de la catégorie SURF

Refarticle - Designation - NB location
*/
/*
SELECT COUNT(refart) AS nbLocSurf 
FROM lignesFic lf
INNER JOIN fiches f ON f.noFic = lf.noFic
WHERE refart LIKE('S%');
*/
--------
SELECT DISTINCT lf.refart AS [Référence Article],
    designation,
    COUNT(lf.refart) AS [Nombre Locations]
FROM lignesFic lf
INNER JOIN articles a ON a.refart = lf.refart
WHERE lf.refart LIKE('S%')
GROUP BY lf.refart, designation ;
----
/*
j – Calcul du nombre moyen d’articles loués par fiche de location
*/
SELECT lf.noFic,
    COUNT(noLig) AS NombreLocParFiche
INTO #T1
FROM fiches f
INNER JOIN lignesFic lf ON lf.noFic = f.noFic
GROUP BY lf.noFic;
----
SELECT AVG( CAST(NombreLocParFiche  AS DECIMAL(8,6)) )
FROM #T1;

-----
DROP TABLE #T1;
------SELECT lf.noFic,
SELECT COUNT(noLig) AS NombreLocParFiche
FROM fiches f
INNER JOIN lignesFic lf ON lf.noFic = f.noFic
GROUP BY lf.noFic;





