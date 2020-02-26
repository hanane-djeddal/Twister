CREATE DATABASE BDTwister_HANANE_LITICIA;
USE BDTwister_HANANE_LITICIA;
DROP TABLE Session;
DROP TABLE Ami;
DROP TABLE Utilisateur;

CREATE TABLE Utilisateur 
 	(id_user INTEGER PRIMARY KEY AUTO_INCREMENT,
	 login VARCHAR (32) UNIQUE,
	 motDePasse BLOB,
	 nom VARCHAR (255),
	 prenom VARCHAR (255),
	 admin INTEGER);

CREATE TABLE Ami
 	(id_user INTEGER,
	 id_ami INTEGER,
	 PRIMARY KEY (id_user,id_ami),
	 FOREIGN KEY(id_ami) REFERENCES Utilisateur(id_user), 
	 FOREIGN KEY(id_user) REFERENCES Utilisateur(id_user) );

CREATE TABLE Session
 	(id_user INTEGER,
	 clef INTEGER UNIQUE AUTO_INCREMENT,
	 admin INTEGER,
	 date_connexion DATETIME,
	 PRIMARY KEY (id_user,clef),
	 FOREIGN KEY(id_user) REFERENCES Utilisateur(id_user) );



INSERT INTO Utilisateur (login, motDePasse, nom, prenom,admin) VALUES ("login1", "motDePasse1", "nom1", "prenom1",1);
INSERT INTO Utilisateur (login, motDePasse, nom, prenom,admin) VALUES ("login2", "motDePasse2", "nom2", "prenom2",0);
