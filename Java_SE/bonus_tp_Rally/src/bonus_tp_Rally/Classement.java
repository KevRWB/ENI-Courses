package bonus_tp_Rally;

import java.util.Date;

public class Classement {
	private Date cumulTemps;
	private Equipage equipage;
	
	//Constructor
	public Classement(Date cumulTemps, Equipage equipage) {
		this.cumulTemps = cumulTemps;
		this.equipage = equipage;
	}

	public Date getCumulTemps() {
		return cumulTemps;
	}

	public String infosClassement() {
		StringBuilder builder = new StringBuilder();
		builder.append("Classement [cumulTemps=");
		builder.append(cumulTemps);
		builder.append(", equipage=");
		builder.append(equipage);
		builder.append("]");
		return builder.toString();
	}


	
}
