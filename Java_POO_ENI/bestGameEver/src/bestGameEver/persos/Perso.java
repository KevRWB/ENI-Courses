package bestGameEver.persos;

import bestGameEver.races.Race;

public class Perso {
	protected String name;
	protected int att;
	protected int def;
	protected int ability;
	protected int speed;
	protected int dodge;
	protected int life;
	protected int initiative;
	protected Race race;
	//CONSTRUCTOR
	public Perso(String name, int att, int def, int ability, int speed, int dodge, int life, int initiative,Race race) {
		super();
		this.name = name;
		this.att = att;
		this.def = def;
		this.ability = ability;
		this.speed = speed;
		this.dodge = dodge;
		this.life = life;
		this.initiative = initiative;
		this.race = race;
	}
	
	//GETTERS SETTERS
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
	public int getAbility() {
		return ability;
	}
	public void setAbility(int ability) {
		this.ability = ability;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getDodge() {
		return dodge;
	}
	public void setDodge(int dodge) {
		this.dodge = dodge;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public int getInitiative() {
		return initiative;
	}
	public void setInitiative(int initiative) {
		this.initiative = initiative;
	}
	public Race getRace() {
		return race;
	}
	public void setRace(Race race) {
		this.race = race;
	}	
	
}
