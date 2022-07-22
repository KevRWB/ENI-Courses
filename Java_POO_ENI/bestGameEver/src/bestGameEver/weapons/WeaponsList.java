package bestGameEver.weapons;

import java.util.ArrayList;

public class WeaponsList {

	private static ArrayList<Weapon> weaponsList = new ArrayList<Weapon>();
	//METHODS
	public  static ArrayList<Weapon> getMonstersList(){
		Weapon hache = new Weapon(1, "hache", 6, 2, 20, false, 0);
		Weapon dague = new Weapon(2, "dague", 3, 8, 20, false, 0);
		Weapon arc = new Weapon(3, "arc", 5, 1, 20, true, 10);
		
		//add Monsters to list
		weaponsList.add(hache); 
		weaponsList.add(dague);
		weaponsList.add(arc);
		//return
		return weaponsList;
	}
}
