package fr.eni.vault;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TestAjouterObjet.class,
	TestOpenVault.class,
	TestRemoveObject.class,
	TestVaultClose.class,
})
public class AllTests {

}
