package bestGameEver.persos.monsters;

import java.util.ArrayList;

import bestGameEver.items.Item;
import bestGameEver.items.clothes.Cloth;
import bestGameEver.items.shields.Shield;
import bestGameEver.items.weapons.Weapon;
import bestGameEver.persos.Perso;
import bestGameEver.races.Race;

public class Monster extends Perso{
	//--attributs
	private int index;
	private Weapon weaponOne;
	private Weapon weaponTwo;
	private Shield shield;
	private ArrayList<Item> itemsList= new ArrayList<Item>();
	private ArrayList<Cloth> clothesList = new ArrayList<Cloth>();
	private static int nbMonsters;
	//INIT METHODS
	static {
		nbMonsters = 1;
	}
	
	//CONSTRUCTOR
	public Monster(String name, int att, int def, int ability, int speed, int dodge, int life, int initiative,Race race){
		super(name, att, def, ability, speed, dodge, life,  initiative, race);
		index = nbMonsters;
		nbMonsters ++;
	}
	
	//METHODS
	public void printMonsterStats() {	
		System.out.println(": --- " + name.toUpperCase() + " --- ");
		System.out.println("Attaque : " + att + " Défense : " + def);
		System.out.println("Habileté : " + ability + " Vitesse : " + speed);
		System.out.println("Esquive : " + dodge + " Initiative : " + initiative);
		System.out.println("Points de vie : " + life);
		if(race != null) System.out.println("Race : " + race);
		System.out.println("-----------------");
	}
	
	public void printMonsterWeapons() {
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
	
	//GETTERS SETTERS
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
}
