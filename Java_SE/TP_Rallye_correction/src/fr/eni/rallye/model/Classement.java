package fr.eni.rallye.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Classement {

	private Equipage equipage;
	
	private Date cumulTemps;

	public Date getCumulTemps() {
		return cumulTemps;
	}

	public Classement(Equipage equipage, Date cumulTemps) {
		this.equipage = equipage;
		this.cumulTemps = cumulTemps;
	}
	
	public String infosClassement() {
		SimpleDateFormat sdf = new SimpleDateFormat("mm:ss sss");
		StringBuilder sb = new StringBuilder("Classement [equipage=");
		sb.append(equipage.infosEquipage())
			.append(System.lineSeparator())
			.append(", temps cumulés=")
			.append(sdf.format(cumulTemps))
			.append("]");
		return sb.toString();
	}
}
