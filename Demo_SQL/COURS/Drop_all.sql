--DROP ALL


--DROP FK
ALTER TABLE Fiches DROP
	CONSTRAINT FK_Fiches_noCli;

ALTER TABLE LignesFic DROP
	CONSTRAINT FK_LignesFic_refart;

ALTER TABLE LignesFic DROP
	CONSTRAINT FK_LignesFic_noFic;

ALTER TABLE	Articles DROP
	CONSTRAINT FK_Articles;

ALTER TABLE GrilleTarifs DROP
	CONSTRAINT FK_GrilleTarifs_CodeTarif;

ALTER TABLE GrilleTarifs DROP
	CONSTRAINT FK_GrilleTarifs_codeGam;

ALTER TABLE GrilleTarifs DROP
	CONSTRAINT FK_GrilleTarifs_codeCate;

--DROP TABLES

DROP TABLE Clients, Fiches, LignesFic, Articles, Gammes, GrilleTarifs, Categories, Tarifs;





