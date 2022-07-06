/*
TRANSACTIONS
*/

BEGIN TRAN MAJ_DATA;

INSERT INTO Services (CodeService, Libelle)
	VALUES('SERV7', 'Service7');

SAVE TRAN BEFORE_DELETE;

DELETE FROM Employes;

SELECT TOP (1000) [CodeEmp]
      ,[Nom]
      ,[Prenom]
      ,[DateNaissance]
      ,[DateEmbauche]
      ,[DateModif]
      ,[Salaire]
      ,[CodeService]
      ,[CodeChef]
      ,[Age]
  FROM [GESTION_EMPLOYES].[dbo].[Employes];


ROLLBACK TRAN MAJ_DATA;

ROLLBACK TRAN BEFORE_DELETE;

COMMIT TRAN MAJ_DATA;