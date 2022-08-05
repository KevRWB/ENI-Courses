package fr.eni.rallye.model;

public class Equipe {

	private String nom;
	
	private String nationalite;
	
	private boolean constructeur;
	
	private int equipageIndex = 0;
	
	private Equipage[] equipages = new Equipage[3];

	public Equipe(String nom, String nationalite, boolean constructeur) {
		this.nom = nom;
		this.nationalite = nationalite;
		this.constructeur = constructeur;
	}
	
	public void ajouterEquipage(Equipage equipage) {
		equipages[equipageIndex] = equipage;
		equipageIndex++;
	}
	
	public String infosEquipe() {
		StringBuilder sb = new StringBuilder("Equipe [nom=");
		sb.append(nom)
			.append(", nationalité=")
			.append(nationalite)
			.append(", constructeur=")
			.append(constructeur)
			.append("]")
			.append(System.lineSeparator());
		for(int i = 0 ; i < equipageIndex ; i++) {
			sb.append("\t")
				.append(equipages[i].infosEquipage())
				.append(System.lineSeparator());
		}
		return sb.toString();
	}
	
	public Equipage getEquipage(int dossard) {
		for(int i = 0 ; i < equipageIndex ; i++) {
			if(equipages[i].getDossard() == dossard) {
				return equipages[i];
			}
		}
		return null;
	}
}


