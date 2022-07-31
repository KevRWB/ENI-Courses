package bestGameEver.races;

import java.util.ArrayList;

public class RacesList {
	//List of potions in Array list
		private static ArrayList<Race> raceList = new ArrayList<Race>();
		
		public static  ArrayList<Race> getPotionsList () {
			Race human = new Race("Humain", null, 0, 2, 0, 0, 2, 0);
			Race elfe = new Race("Elfe", null, 0, 0, 2, 2, 0, 1);
			Race orc = new Race("Orc", null, 2, 0, 0, 0, 3, 0);
			//add potions in ArrayList
			raceList.add(human);
			raceList.add(elfe);
			raceList.add(elfe);
			
			return raceList;
		}

}
