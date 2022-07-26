package bestGameEver.tests;

import bestGameEver.fonctions.FightFunctions;
import bestGameEver.persos.Perso;
import bestGameEver.persos.heroes.HeroesList;
import bestGameEver.persos.monsters.MonstersList;

public class Tests {

	public static void main(String[] args) {
		
		Perso attacker = HeroesList.getHeroesList().get(1);
		Perso defender = MonstersList.getMonstersList().get(1);
		
		boolean touche = FightFunctions.testNormalTouch(attacker, 0, defender, 6);
		System.out.println(touche);
		
	}
}
