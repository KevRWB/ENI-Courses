package bestGameEver.heros;

public class Hero {
	private String name;
	private int att;
	private int def;
	private int vie;
	
	public Hero(String name, int att, int def, int vie) {
		this.name = name;
		this.att = att;
		this.def = def;
		this.vie = vie;
				
	}
	
	//  METHODS
	//getters
	public String getName() {
		return this.name;
	}
	public int getAtt() {
		return this.att;
	}
	public int getDef() {
		return this.def;
	}
	public int getVie() {
		return this.vie;
	}
	public void removeVie(int nb) {
		this.vie = this.vie - nb;
	}
	//affichage
	public void afficherHero() {
		System.out.println("Nom : " + this.name);
		System.out.println("Attaque : " + this.att);
		System.out.println("Défense : " + this.def);
		System.out.println("Points de vie : " + this.vie);
	}

}
