package bonus_tp_Rally;

import java.util.Date;

public class Resultat {
	private Date temps;
	private Equipage equipage;
	private Speciale speciale;
	
	//Constructor
	public Resultat( Equipage equipage, Speciale speciale, Date date) {
		this.temps = date;
		this.equipage = equipage;
		this.speciale = speciale;
		this.speciale.ajouterResultat(this);
	}
	
	//Get - Set
	public Date getTemps() {
		return temps;
	}
	
	public Equipage getEquipage() {
		return equipage;
	}
	public Speciale getSpeciale() {
		return speciale;
	}

	
	//toString
	public String infosResultat() {
		StringBuilder builder = new StringBuilder();
		builder.append("Resultat [temps=");
		builder.append(temps);
		builder.append(", equipage=");
		builder.append(equipage);
		builder.append("]");
		return builder.toString();
	}

}
