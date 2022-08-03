package fr.eni.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnexion {

	public static void main(String[] args) throws SQLException { // throws SQLException -> Pas bien , ça force le crash
		//A l'ancienne
		//activer le port tcpip de sql server -> Gestionnaire de configuration sql serveur (execute admin)
		//Configuration du reseau sql serveur -> Protocoles pour MSSQL -> activer TCPIP
		//-> Redémarrer sql serveur
		
		//trouver chemin jdk
		//preference -> jdk -> copy path
		
		//Si erreur SSL
		//jdk -> conf -> security -> java-security -> chercher TLSv1 -> Supprimer les occurences
		
		String url = "jdbc:sqlserver://localhost/1433;databasename=PAPETERIE_DB";
		String user = "sa";
		String password = "Pa$$w0rd";
		Connection cnx = DriverManager.getConnection(url, user, password);
		if(!cnx.isClosed()) {
			System.out.println("Connexion ouverte");
		}else {
			System.out.println("Pas de connexion");
		}
		
		cnx.close();
		
		//Nouvelle methode : auto-closable
		try(Connection cnx2 = DriverManager.getConnection(url, user, password)){
			if(!cnx2.isClosed()) {
				System.out.println("Connexion ouverte");
			}else {
				System.out.println("Pas de connexion");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

	}

}
