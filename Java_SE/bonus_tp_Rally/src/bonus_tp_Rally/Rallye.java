package bonus_tp_Rally;

import java.util.Arrays;
import java.util.Date;

public class Rallye {
	
	private Date date;
	private String pays;
	private int specialeIndex = 0;
	private Speciale[] speciales = new Speciale[20];
	
	//constructor
	public Rallye(String pays, Date date) {
		this.date = date;
		this.pays = pays;
	}
	

	//METHODS
	public void ajouterSpeciale(Speciale speciale) {
		speciales[specialeIndex] = speciale;
		specialeIndex++;
	}
	
	public String infosRallye(Boolean inclureSpeciale) {
		StringBuilder builder = new StringBuilder();
		builder.append("Rallye [date=");
		builder.append(date);
		builder.append(", pays=");
		builder.append(pays + "\n");
		for (int i = 0; i < specialeIndex; i++) {
			builder.append(speciales[i] + "\n");
		}
		builder.append("]\n");
		return builder.toString();
		
		
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
