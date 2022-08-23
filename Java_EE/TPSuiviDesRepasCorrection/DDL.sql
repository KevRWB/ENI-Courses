CREATE TABLE REPAS
(
	id int AUTO_INCREMENT CONSTRAINT PK_REPAS PRIMARY KEY,
	date_repas date NOT NULL ,
	heure_repas time NOT NULL
);

CREATE TABLE ALIMENTS
(
	id int AUTO_INCREMENT CONSTRAINT PK_ALIMENTS PRIMARY KEY,
	nom varchar(50) NOT NULL,
	id_repas int NOT NULL
);

ALTER TABLE ALIMENTS ADD CONSTRAINT
	FK_ALIMENTS_REPAS FOREIGN KEY(id_repas) REFERENCES REPAS(id);