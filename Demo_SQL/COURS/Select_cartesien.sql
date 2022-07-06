/*
SELECT CARTESIEN -- multi tables
*/
--BAD METHOD
SELECT * FROM Services 
CROSS JOIN Employes;

SELECT  Services.CodeService, libelle, nom prenom -- prefix Code service car ambigue entre les deux tables
FROM Services
CROSS JOIN Employes;




