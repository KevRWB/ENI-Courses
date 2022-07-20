package bestGameEver.monsters;

public class Monster {
	//--attributs
	private String name;
	private int att;
	private int def;
	private int vie;
	//constructeur
	public Monster(String name, int att, int def, int vie) {
		this.name = name;
		this.att = att;
		this.def = def;
		this.vie = vie;
	}
	//getters setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAtt() {
		return att;
	}
	public void setAtt(int att) {
		this.att = att;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getVie() {
		return vie;
	}
	public void setVie(int vie) {
		this.vie = vie;
	}
	// --- METHODS
	public void afficherMonster() {
		System.out.println("Nom : " + this.name);
		System.out.println("Attaque : " + this.att);
		System.out.println("Défense : " + this.def);
		System.out.println("Points de vie : " + this.vie);
	}
	
}
