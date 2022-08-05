package fr.eni.rallye.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Resultat {

	private Equipage equipage;
	
	private Date temps;
	
	private Speciale speciale;

	public Resultat(Equipage equipage, Speciale speciale, Date temps) {
		this.equipage = equipage;
		this.speciale = speciale;
		this.temps = temps;
		this.speciale.ajouterResultat(this);
	}

	public Equipage getEquipage() {
		return equipage;
	}

	public Date getTemps() {
		return temps;
	}

	public Speciale getSpeciale() {
		return speciale;
	}
	
	public String infosResultat() {
		SimpleDateFormat sdf = new SimpleDateFormat("mm:ss sss");
		StringBuilder sb = new StringBuilder("Resultat [speciale=");
		sb.append(speciale.infosSpeciale())
			.append(System.lineSeparator())
			.append(", equipage=")
			.append(equipage.infosEquipage())
			.append(System.lineSeparator())
			.append(", temps=")
			.append(sdf.format(temps))
			.append("]")
			.append(System.lineSeparator());
		return sb.toString();			
	}
}



