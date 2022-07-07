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
ALTER TABLE lignesFic ADD CONSTRAINT DF_noFic_retour DEFAULT GETDATE() FOR retour;
ALTER TABLE lignesFic DROP CONSTRAINT DF_noFic_retour;

SELECT DISTINCT f.noFic AS [Fiche N°],
    nom,
    prenom,
    lf.refart AS [Référence],
    designation,
    depart,
    retour,
    prixJour,
    ((DATEDIFF(DAY, depart, retour)) * prixJour) AS Montant

FROM fiches f 
INNER JOIN lignesFic lf ON lf.noFic = f.noFic
INNER JOIN clients c ON c.noCli = f.noCli
INNER JOIN articles a ON a.refart = lf.refart
INNER JOIN  grilleTarifs gt ON gt.codeCate = a.codeCate AND gt.codeGam = a.codeGam
INNER JOIN tarifs t ON t.codeTarif = gt.codeTarif
WHERE f.noFic = 1002;

