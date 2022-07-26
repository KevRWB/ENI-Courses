package bestGameEver.persos.heroes;

import java.util.ArrayList;

import bestGameEver.items.Item;
import bestGameEver.items.clothes.Cloth;
import bestGameEver.items.shields.Shield;
import bestGameEver.items.weapons.Weapon;
import bestGameEver.persos.Perso;
import bestGameEver.races.Race;

public class Hero extends Perso{
	private int index;
	private Weapon weaponOne = null;
	private Weapon weaponTwo = null;;
	private Shield shield = null;
	private ArrayList<Item> itemsList= new ArrayList<Item>();
	private ArrayList<Cloth> clothesList = new ArrayList<Cloth>();
	private int xp = 0;
	private int level = 1;
	private static int nbHeroes;
	//INIT METHODS
	static {
		nbHeroes = 1;
	}
	
	//CONSTRUCTOR
	public Hero(String name, int att, int def, int ability, int speed, int dodge, int life, int initiative,Race race) {
		super(name, att, def, ability, speed, dodge, life, initiative, race);
		index = nbHeroes;
		nbHeroes ++;
	}
	//  METHODS
	
	//Print heroes stats
	public void printHeroStats() {	
		System.out.println(" --- " +name.toUpperCase() + " --- ");
		System.out.println("Attaque : " + att + " Défense : " + def);
		System.out.println("Habileté : " + ability + " Vitesse : " + speed);
		System.out.println("Esquive : " + dodge + " Initiative : " + initiative);
		System.out.println("Points de vie : " + life);
		if(race != null) System.out.println("Race : " + race);
		System.out.println("-----------------");
	}
	
	public void printHeroWeapons() {
		if(this.getWeaponOne() != null || this.getWeaponTwo() != null) {
			System.out.println(" Armes : ");
			System.out.println("----");
		}
		if(this.getWeaponOne() != null) {
			this.getWeaponOne().afficher();
		}
		if(this.getWeaponTwo() != null) {
			this.getWeaponTwo().afficher();
		}
	}
	

	//GETTERS / SETTERS
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public Weapon getWeaponOne() {
		return weaponOne;
	}
	public void setWeaponOne(Weapon weaponOne) {
		this.weaponOne = weaponOne;
	}
	public Weapon getWeaponTwo() {
		return weaponTwo;
	}
	public void setWeaponTwo(Weapon weaponTwo) {
		this.weaponTwo = weaponTwo;
	}
	public Shield getShield() {
		return shield;
	}
	public void setShield(Shield shield) {
		this.shield = shield;
	}
	public ArrayList<Item> getItemsList() {
		return itemsList;
	}
	public void setItemsList(ArrayList<Item> itemsList) {
		this.itemsList = itemsList;
	}
	public ArrayList<Cloth> getClothesList() {
		return clothesList;
	}
	public void setClothesList(ArrayList<Cloth> clothesList) {
		this.clothesList = clothesList;
	}
	public int getXp() {
		return xp;
	}
	public void setXp(int xp) {
		this.xp = xp;
	}
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	
}
