package fr.eni.rallye.model;

public class Equipage {

	private Concurrent pilote;
	
	private Concurrent copilote;
	
	private int dossard;

	public Equipage(int dossard, String nomPilote, String prenomPilote, String nationalitePilote,
					String nomCopilote, String prenomCopilote, String nationaliteCopilote) {
		this.pilote = new Concurrent(nomPilote, prenomPilote, nationalitePilote);
		this.copilote = new Concurrent(nomCopilote, prenomCopilote, nationaliteCopilote);
		this.dossard = dossard;
	}

	public int getDossard() {
		return dossard;
	}
	
	public String infosEquipage() {
		StringBuilder sb = new StringBuilder("Equipage [dossard=");
		sb.append(dossard)
			.append(System.lineSeparator())
			.append(pilote.infosConcurrent())
			.append(System.lineSeparator())
			.append(copilote.infosConcurrent())
			.append("]");
		
		return sb.toString();
	}
}



