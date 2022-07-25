package tpLocationCycles;

import java.time.LocalDate;

public class TestCycles {

	public static void main(String[] args) {
		
		Velo lapierre = new Velo("Lapierre", "speed 400", LocalDate.of(2021, 01, 5), 27 );
		Velo btwin = new Velo("Btwin", "riverside 900", LocalDate.of(2022, 01, 5), 10 );
		Gyropode segway = new Gyropode("Segway", "Ninebot",  LocalDate.of(2021, 01, 5), 40, "1m50");
		Gyropode weebot = new Gyropode("Weebot", "Echo",  LocalDate.of(2020, 01, 5), 35, "1m60");
		Gyroroue immotion = new Gyroroue("Immotion", "v8", LocalDate.of(2020, 01, 5), 40);
		Gyroroue ninebot = new Gyroroue("Segway", "Ninebot One E+", LocalDate.of(2020, 01, 5), 30);
		
		//AFFICHAGES
		lapierre.afficher();
		btwin.afficher();
		segway.afficher();
		weebot.afficher();
		immotion.afficher();
		ninebot.afficher();	
	
	}
	
}
