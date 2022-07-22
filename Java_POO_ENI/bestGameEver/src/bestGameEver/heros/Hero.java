package bestGameEver.heros;

public class Hero {
	private int index;
	private String name;
	private int att;
	private int def;
	private int life;
	private int initiative;
	
	
	public Hero(int index,String name, int att, int def, int life, int initiative) {
		this.index = index;
		this.name = name;
		this.att = att;
		this.def = def;
		this.life = life;
		this.initiative = initiative;		
	}
	//  METHODS
	//getters
	public int getIndex() {
		return this.index;
	}
	public String getName() {
		return this.name;
	}
	public int getAtt() {
		return this.att;
	}
	public int getDef() {
		return this.def;
	}
	public int getLife() {
		return this.life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public int getInitiative() {
		return this.initiative;
	}
	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}
	

}
