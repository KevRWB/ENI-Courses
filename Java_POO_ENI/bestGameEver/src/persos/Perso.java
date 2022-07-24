package persos;

import bestGameEver.items.Item;
import bestGameEver.items.clothes.Cloth;
import bestGameEver.items.weapons.Weapon;

public class Perso {
	protected String name;
	protected int att;
	protected int def;
	protected int life;
	protected int initiative;
	protected int weightToCarry;
	
	protected Weapon[] weaponList = new Weapon[5];
	protected Cloth[] clothesList = new Cloth[10];
	protected Item[] itemsList = new Item[10];
	
	
}
