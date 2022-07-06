USE Locations;
GO


/*création des tables*/
CREATE TABLE clients(
	noCli		NUMERIC(6)		CONSTRAINT pk_clients PRIMARY KEY,
	nom			VARCHAR(30)		NOT NULL,
	prenom		VARCHAR(30)		NULL,
	adresse		VARCHAR(120)	NULL,
	cpo			CHAR(5)			NOT NULL
								CONSTRAINT CK_Clients_cpo CHECK(CONVERT(NUMERIC(5), cpo) BETWEEN 1000 AND 95999),
	ville		VARCHAR(80)		CONSTRAINT df_clients_ville DEFAULT 'Nantes' NOT NULL
);

CREATE TABLE fiches(
	noFic		NUMERIC(6)		CONSTRAINT pk_fiches PRIMARY KEY,
	noCli		NUMERIC(6)		NOT NULL,
	dateCrea	DATETIME		CONSTRAINT df_fiches_dateCrea DEFAULT GETDATE() NOT NULL	,
	datePaye	DATETIME		NULL,
	etat		CHAR(2)			CONSTRAINT df_fiches_etat DEFAULT 'EC' NOT NULL
								CONSTRAINT CK_Fiches_etat CHECK(etat IN ('EC', 'RE', 'SO')),--(etat = 'EC' OR etat = 'RE' OR etat='SO'),
	CONSTRAINT CK_Fiches_VerifDate CHECK (datePaye is null OR datePaye>dateCrea),
	CONSTRAINT CK_Fiches_datePaye_etat CHECK((etat = 'SO' AND datePaye is not null) OR (datePaye is null AND etat!='SO'))
);

CREATE TABLE gammes(
	codeGam		CHAR(5)			CONSTRAINT pk_gammes PRIMARY KEY,
	libelle		VARCHAR(30)		NOT NULL
								CONSTRAINT UN_Gamme_libelle UNIQUE
);

CREATE TABLE categories(
	codeCate	CHAR(5)			CONSTRAINT pk_categories PRIMARY KEY,
	libelle		VARCHAR(30)		NOT NULL
								CONSTRAINT un_categories_libelle UNIQUE
);

CREATE TABLE tarifs(
	codeTarif	CHAR(5)			CONSTRAINT pk_tarifs PRIMARY KEY,
	libelle		VARCHAR(30)		NOT NULL
								CONSTRAINT un_tarifs_libelle UNIQUE,
	prixJour	NUMERIC(5,2)	NOT NULL
								CONSTRAINT ck_tarifs_prixJour CHECK(prixJour >= 0)
);

CREATE TABLE grilleTarifs(
	codeGam		CHAR(5),
	codeCate	CHAR(5),
	codeTarif	CHAR(5)			NOT NULL,
	CONSTRAINT pk_grilleTarifs PRIMARY KEY (codeGam, codeCate)
);

CREATE TABLE articles(
	refart		CHAR(3)			CONSTRAINT pk_articles PRIMARY KEY,
	designation VARCHAR(80)		NOT NULL,
	codeGam		CHAR(5)			NOT NULL,
	codeCate	CHAR(5)			NOT NULL
);

CREATE TABLE lignesFic(
	noFic		NUMERIC(6),
	noLig		NUMERIC(3),
	refart		CHAR(3)			NOT NULL,
	depart		DATETIME		DEFAULT GETDATE() NOT NULL,
	retour		DATETIME		NULL,
	CONSTRAINT pk_lignesFic PRIMARY KEY(noFic, noLig),
	CONSTRAINT ck_lignesFic_dates CHECK(retour is null or retour>depart)
);
GO


/*mise en place de l'intégrité référentielle*/
ALTER TABLE fiches ADD
	CONSTRAINT FK_Fiches_nocli FOREIGN KEY(noCli)
		REFERENCES Clients(noCli) ON DELETE CASCADE;

ALTER TABLE lignesFic ADD
	CONSTRAINT FK_LignesFic_noFic FOREIGN KEY(noFic)
		REFERENCES Fiches(noFic) ON DELETE CASCADE,
	CONSTRAINT FK_LignesFic_refart FOREIGN KEY(refart)
		REFERENCES Articles(refart);

ALTER TABLE Articles ADD
	CONSTRAINT FK_Articles_GrilleTarifs FOREIGN KEY(codeGam, codeCate)
		REFERENCES GrilleTarifs(codeGam, codeCate);

ALTER TABLE GrilleTarifs ADD
	CONSTRAINT FK_GrilleTarifs_codeGam FOREIGN KEY(codeGam)
		REFERENCES Gammes(codeGam),
	CONSTRAINT FK_GrilleTarifs_codeCate FOREIGN KEY(codeCate)
		REFERENCES Categories(codeCate),
	CONSTRAINT FK_GrilleTarifs_codeTarif FOREIGN KEY(codeTarif)
		REFERENCES Tarifs(codeTarif);


/*création des index sur les clés étrangères*/
CREATE NONCLUSTERED INDEX fk_fiches_clients
	ON fiches(noCli ASC);

CREATE NONCLUSTERED INDEX fk_grilleTarifs_gammes
	ON grilleTarifs(codeGam ASC);
CREATE NONCLUSTERED INDEX fk_grilleTarifs_categories
	ON grilleTarifs(codeCate ASC);
CREATE NONCLUSTERED INDEX fk_grilleTarifs_tarifs
	ON grilleTarifs(codeTarif ASC);

CREATE NONCLUSTERED INDEX fk_articles_grilleTarifs
	ON articles(codeGam ASC, codeCate ASC);

CREATE NONCLUSTERED INDEX fk_lignesFic_fiches
	ON lignesFic(noFic ASC);
CREATE NONCLUSTERED INDEX fk_lignesFic_articles
	ON lignesFic(refart ASC);
GO