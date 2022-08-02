package bonus_tp_Rally;

public class Equipage {
	private int dossard;
	private Concurrent pilote;
	private Concurrent copilote;
	
	//Constructor
	public Equipage(String nomPilote, String prenomPilote, String nationalitePilote, String nomCoPilote, String prenomCoPilote, String nationaliteCoPilote, int dossard) {
		pilote = new Concurrent(nomPilote, prenomPilote, nationalitePilote);
		copilote = new Concurrent(nomCoPilote, prenomCoPilote, nationaliteCoPilote);
		this.dossard = dossard;
	}
	
	//---Methods
	public int getDossard() {
		return this.dossard;
	}

	//ToString
	public String infosEquipage() {
		StringBuilder builder = new StringBuilder();
		builder.append("Equipage [dossard=");
		builder.append(dossard);
		builder.append(", pilote=");
		builder.append(pilote);
		builder.append(", copilote=");
		builder.append(copilote);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
