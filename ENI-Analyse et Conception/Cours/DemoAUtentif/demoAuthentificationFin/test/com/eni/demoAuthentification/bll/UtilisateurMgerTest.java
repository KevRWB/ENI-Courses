package com.eni.demoAuthentification.bll;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.eni.demoAuthentification.dao.UtilisateurDAOImplSTUB;

public class UtilisateurMgerTest {

	@Test
	public void testAuthentifierPositif() throws BLLException {
		//Arrange
		UtilisateurMger mger = new UtilisateurMger(new UtilisateurDAOImplSTUB());
		String user = "bob";
		String password = "Pa$$w0rd";
		
		//Act
		boolean resultat = mger.authentifier(user, password);
		
		
		//Assert
		assertTrue(resultat);
		
	}

	@Test
	public void testAuthentifierPasswordInvalide() throws BLLException {
		//Arrange
		UtilisateurMger mger = new UtilisateurMger(new UtilisateurDAOImplSTUB());
		String user = "bob";
		String password = "azerty";
		
		//Act
		boolean resultat = mger.authentifier(user, password);
		
		
		//Assert
		assertFalse(resultat);
		
	}

	@Test
	public void testAuthentifierLoginInvalide() throws BLLException {
		//Arrange
		UtilisateurMger mger = new UtilisateurMger(new UtilisateurDAOImplSTUB());
		String user = "joe";
		String password = "azerty";
		
		//Act
		boolean resultat = mger.authentifier(user, password);
		
		
		//Assert
		assertFalse(resultat);
		
	}
	
}
