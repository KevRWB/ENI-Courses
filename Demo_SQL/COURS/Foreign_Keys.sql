--FOREIGN KEYS
--Mise en place de l'intégrité référentielle

ALTER TABLE Fiches ADD
	CONSTRAINT FK_Fiches_noCli FOREIGN KEY(noCli)
		REFERENCES Clients(noCli) ON DELETE CASCADE;

ALTER TABLE LignesFic ADD
	CONSTRAINT FK_LignesFic_refart FOREIGN KEY(refart)
		REFERENCES Articles(refart),
	CONSTRAINT FK_LignesFic_noFic FOREIGN KEY(noFic)
		REFERENCES Fiches(noFic);

ALTER TABLE Articles ADD
	CONSTRAINT FK_Articles FOREIGN KEY(codeGam, codeCate)
		REFERENCES GrilleTarifs(codeGam, codeCate);

ALTER TABLE GrilleTarifs ADD
	CONSTRAINT FK_GrilleTarifs_CodeTarif FOREIGN KEY(codeTarif)
		REFERENCES Tarifs(codeTarif);

ALTER TABLE  GrilleTarifs ADD
	CONSTRAINT FK_GrilleTarifs_codeGam FOREIGN KEY (codeGam)
		REFERENCES Gammes(codeGam);

ALTER TABLE GrilleTarifs ADD
	CONSTRAINT FK_GrilleTarifs_codeCate FOREIGN KEY(codeCate)
		REFERENCES Categories(codeCate);


