package bestGameEver.items.weapons;

import java.util.ArrayList;

public class WeaponsList {

	private static ArrayList<Weapon> weaponsList = new ArrayList<Weapon>();
	//METHODS
	public  static ArrayList<Weapon> getWeaponsList(){
		Weapon hache = new Weapon("Hache", null, null, 20, 10, 6, 2, false, 0);
		Weapon dague = new Weapon("Dague", null, null, 20, 2, 2, 8, false, 0);
		Weapon arc = new Weapon("Arc",null, null, 20, 7, 5, 1, true, 5);
		
		//add Monsters to list
		weaponsList.add(hache); 
		weaponsList.add(dague);
		weaponsList.add(arc);
		//return
		return weaponsList;
	}	
}
