package bonus_tp_Rally;

import java.util.Date;

public class Resultat {
	private Date temps;
	private Equipage equipage;
	private Speciale speciale;
	
	//Constructor
	public Resultat(Date temps, Equipage equipage, Speciale speciale) {
		super();
		this.temps = temps;
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
	public String infosResultats() {
		StringBuilder builder = new StringBuilder();
		builder.append("Resultat [temps=");
		builder.append(temps);
		builder.append(", equipage=");
		builder.append(equipage);
		builder.append("]");
		return builder.toString();
	}

	
}
