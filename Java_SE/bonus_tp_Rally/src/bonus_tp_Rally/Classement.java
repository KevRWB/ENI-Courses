package bonus_tp_Rally;

import java.util.Date;

public class Classement {
	private Date cumulTemps;
	private Equipage equipage;
	
	//Constructor
	public Classement(Equipage equipage, Date cumulTemps) {
		this.cumulTemps = cumulTemps;
		this.equipage = equipage;
	}
	//methods
	public Date getCumulTemps() {
		return cumulTemps;
	}
	
	//
	
	//toString
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
