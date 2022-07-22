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
	public Monster(int index, String name, int att, int def, int life, int initiative){
		this.index = index;
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
}
