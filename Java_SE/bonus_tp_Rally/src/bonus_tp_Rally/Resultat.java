package bonus_tp_Rally;

import java.util.Date;

public class Resultat {
	private Date temps;
	private Equipage equipage;
	private Speciale speciale;
	
	//Constructor
	public Resultat(Equipage date, Speciale speciale, Date date1) {
		this.temps = date1;
		this.equipage = equipage;
		this.speciale = speciale;
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
