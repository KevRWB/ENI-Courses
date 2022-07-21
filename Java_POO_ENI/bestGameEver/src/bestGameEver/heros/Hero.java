package bestGameEver.heros;

public class Hero {
	private int index = 1;
	private String name;
	private int att;
	private int def;
	private int life;
	private int initiative;
	
	public Hero(String name, int att, int def, int life, int initiative) {
		this.name = name;
		this.att = att;
		this.def = def;
		this.life = life;
		this.initiative = initiative;
		this.index ++;		
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
	//affichage
	//fonction print hero
	public static void printHero(Hero hero) {
		System.out.println("--------------------");
		System.out.printf("%d : %s%n", hero.getIndex(), hero.getName());
		System.out.println("Attaque : " + hero.getAtt());
		System.out.println("Défense : " + hero.getDef());
		System.out.println("Points de vie : " + hero.getLife());
		System.out.println("Initiative : " + hero.getInitiative());
		System.out.println("-------------------");
	}
	//toString

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Hero [index=");
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
