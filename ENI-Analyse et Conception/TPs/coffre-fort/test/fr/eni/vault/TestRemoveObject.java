package fr.eni.vault;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.eni.vault.bll.BLLException;
import com.eni.vault.bll.Storable;
import com.eni.vault.bll.Vault;
import com.eni.vault.bo.Gold;

public class TestRemoveObject {
	
	Vault vault = new Vault();
	
	@Test
	public void testRemoveObject() throws BLLException{
		//Arrange
		Storable gold = new Gold(20);
		vault.addObject(gold);
		
		//Act remove Object in the vault
		int listObjectSize = vault.removeObject(gold);

		//Assert
		assertEquals(listObjectSize, 0, "Echec fonction removeObject");
	
	}
	
	@Test
	public void testRemoveObjectVaultClosed()  throws BLLException {
		//Arrange
		Storable gold = new Gold(20);
		vault.addObject(gold);
		vault.lock("1234");

		//Assert and act
		assertThrows(BLLException.class,() -> vault.removeObject(gold));
	
	}
	
}
