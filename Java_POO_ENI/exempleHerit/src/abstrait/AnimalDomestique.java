package abstrait;

public abstract class AnimalDomestique implements Communiquer{
	protected String nom;

	public AnimalDomestique(String nom) {
		this.nom = nom;
	}
	
	//methode abstraite commune à tous les animaix domestiques
	//public abstract void communiquer();
	
}
