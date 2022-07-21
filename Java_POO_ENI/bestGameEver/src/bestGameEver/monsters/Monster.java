package bestGameEver.monsters;

public class Monster {
	//--attributs
	private int index;
	private String name;
	private int att;
	private int def;
	private int life;
	private int initiative;
	//constructeur
	public Monster(String name, int att, int def, int life, int initiative){
		this.index ++;
		this.name = name;
		this.att = att;
		this.def = def;
		this.life = life;
		this.initiative = initiative;
	}
	//getters setters
	public int getIndex() {
		return index;
	}
	
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
	public int getLife() {
		return life;
	}
	public void setLife(int Life) {
		this.life = Life;
	}
	public int getInitiative() {
		return this.initiative;
	}
	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}
	// --- METHODS
	public void afficherMonster() {
		System.out.println("Nom : " + this.name);
		System.out.println("Attaque : " + this.att);
		System.out.println("Défense : " + this.def);
		System.out.println("Points de vie : " + this.life);
	}
	//ToString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Monster [index=");
		builder.append(index);
		builder.append(", name=");
		builder.append(name);
		builder.append(", att=");
		builder.append(att);
		builder.append(", def=");
		builder.append(def);
		builder.append(", life=");
		builder.append(life);
		builder.append(", initiative=");
		builder.append(initiative);
		builder.append("]");
		return builder.toString();
	}
	
	
}
