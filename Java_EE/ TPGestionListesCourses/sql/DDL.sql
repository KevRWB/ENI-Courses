CREATE TABLE LISTES
(
	id int AUTO_INCREMENT CONSTRAINT PK_LISTES PRIMARY KEY,
	nom varchar(50) NOT NULL
);

CREATE TABLE ARTICLES
(
	id int AUTO_INCREMENT CONSTRAINT PK_ARTICLES PRIMARY KEY,
	nom varchar(50) NOT NULL,
	id_liste int NOT NULL
);

ALTER TABLE ARTICLES ADD coche bit default 0;

ALTER TABLE ARTICLES
	ADD CONSTRAINT FK_ARTICLES_LISTES 
		FOREIGN KEY(id_liste) REFERENCES LISTES(id)
		ON DELETE CASCADE;

ALTER TABLE ARTICLES
	DROP CONSTRAINT FK_ARTICLES_LISTES;

	
INSERT INTO LISTES (NOM) VALUES ('Chez Dede');
INSERT INTO LISTES (NOM) VALUES ('Auchan');
INSERT INTO LISTES (NOM) VALUES ('Picard');

INSERT INTO ARTICLES(NOM, ID_LISTE) VALUES ('tofu', 1);
INSERT INTO ARTICLES(NOM, ID_LISTE) VALUES ('carottes', 1);
INSERT INTO ARTICLES(NOM, ID_LISTE) VALUES ('PQ', 2);
INSERT INTO ARTICLES(NOM, ID_LISTE) VALUES ('Cristalline', 2);
INSERT INTO ARTICLES(NOM, ID_LISTE) VALUES ('Glaces nuii', 3);
INSERT INTO ARTICLES(NOM, ID_LISTE) VALUES ('bb congelé', 3);