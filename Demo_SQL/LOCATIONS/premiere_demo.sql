USE GESTION_EMPLOYES
GO

--Commentaire
--Liste des tables utilisateur modifiées au cours des  derniers jours

SELECT name AS nom_table
,SCHEMA_NAME(schema_id) AS nom_schema
,type_desc AS type_table
,create_date AS date_creation
,modify_date AS derniere_modification
FROM sys.objects
WHERE modify_date > GETDATE() - 30 and type_desc = 'USER_TABLE'
ORDER BY modify_date;
