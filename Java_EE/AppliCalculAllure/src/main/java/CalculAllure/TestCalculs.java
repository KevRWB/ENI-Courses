package CalculAllure;

public class TestCalculs {
	
	private static int tpsHeures = 1;
	private static int tpsMinutes = 5;
	private static int tpsSecondes = 5;
	private static int allMinutes;
	private static int allSecondes;
	private static float distance = 9;
	private static float vitesse;
	
	private static String calculToDo;
	
	
	public static void main(String[] args) {
		
		checkWhichCalcul();
		
		calculTpsVitesse(tpsHeures, tpsMinutes, tpsSecondes, vitesse);
		
		printValues();
		
	}
	
	private static void checkWhichCalcul() {
		if(tpsMinutes != 0 && allMinutes !=0) calculToDo = "tpsAllure";
		if(tpsMinutes != 0 && distance !=0) calculToDo = "tpsDistance";
		if(tpsMinutes !=0 && vitesse !=0) calculToDo = "tpsVitesse";
		if(allMinutes !=0 && distance != 0) calculToDo = "allureDistance";
		if(distance !=0 && vitesse !=0) calculToDo = "vitesseDistance";
		System.out.println(calculToDo);
	}
	
	private  static void calculTpsVitesse(int heures, int minutes, int secondes, float vitesseKmH) {
		int tpsSecondes = calculTempsEnSecondes(heures, minutes, secondes);
		distance = vitesseKmH * tpsSecondes/3600;
		
		float allure = 60/vitesseKmH;
		System.out.println("Allure : " + allure);
		
	}
	
	private static int calculTempsEnSecondes(int heures, int minutes, int secondes) {
		return (heures*3600) + (minutes*60) + secondes;
	}
	
	
	
	
	
	private static int getIntPartOfAllure(float allure) {
		return 0;
	}
	
	private static void printValues() {
		System.out.println("Temps : " + tpsHeures + " h : " + tpsMinutes + " min : " + tpsSecondes);
		System.out.println("Allure : " + allMinutes + " min : " + allSecondes + "sec");
		System.out.println("Distance : " + distance + " km");
		System.out.println("Vitesse : " + vitesse + " km/h");
	}

}
