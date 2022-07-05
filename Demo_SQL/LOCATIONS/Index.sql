-- INDEX

-- CREATE [UNIQUE][CLUSTERED | NONCLUSTERED(df)] INDEX index_name
--ON table_name(column_name[ASC | DESC] [,column_name]);

--DROP INDEX index_name ON table_name

--ALTER INDEX {index_name | ALL} ON table_name REBUILT


CREATE NONCLUSTERED INDEX FK_Employes_CodeServices
ON Employes(CodeService ASC);

CREATE INDEX FK_Employes_CodeChef
ON Employes(CodeChef ASC);

CREATE INDEX FK_Conges_Employes
ON Conges (CodeEmp ASC);

CREATE INDEX FK_Conges_Mens
ON Conges_Mens(CodeEmp, Annee);


DROP INDEX FK_Employes_CodeServices ON Employes;

