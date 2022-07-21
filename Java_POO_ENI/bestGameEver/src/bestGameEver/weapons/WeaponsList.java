package bestGameEver.weapons;

import java.util.ArrayList;

public class WeaponsList {

	private static ArrayList<Weapon> weaponsList = new ArrayList<Weapon>();
	//METHODS
	static public ArrayList<Weapon> getMonstersList(){
		Weapon hache = new Weapon("hache", 6, 2, 20, false, 0);
		Weapon dague = new Weapon("dague", 3, 8, 20, false, 0);
		Weapon arc = new Weapon("arc", 5, 1, 20, true, 10);
		
		//add Monsters to list
		weaponsList.add(hache); 
		weaponsList.add(dague);
		weaponsList.add(arc);
		//return
		return weaponsList;
	}
}
