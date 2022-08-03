package bonus_tp_Rally;

import java.sql.Date;

public class Rallye {
	
	private Date date;
	private String pays;
	private int specialeIndex = 0;
	private Speciale[] speciales = new Speciale[20];
	
	//constructor
	public Rallye( String pays, Date date) {
		this.date = date;
		this.pays = pays;
	}
	
	//METHODS
	public void ajouterSpeciale(Speciale speciale) {
		speciales[specialeIndex] = speciale;
		specialeIndex++;
	}
	
	public String infosRallye(Boolean inclureSpeciale) {
		return null;
	}
	
	public Speciale getSpeciale(String nom) {
		Speciale special = null;
		
		for (Speciale speciale : speciales) {
			if(speciale.getNom().equalsIgnoreCase(nom)){
				special = speciale;
			}
		}
		return special;
		
	}
	
	public Classement[] getClassementGeneral() {
		return null;
	}
	
	
	
	
}
