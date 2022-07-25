package fr.eni.ecole.quelMedecin.bo;

public class MedecinSpecialiste extends MedecinGeneraliste {
	
	private String specialite;
	private int tarif;
	
	public MedecinSpecialiste(String nom, String prenom, String numTel, Adresse adresse, String specialite, int tarif) {
		super(nom, prenom, numTel, adresse);
		this.specialite = specialite;
		this.tarif = tarif;
		
	}

	
	//afficher
	@Override
	public void afficher() {
		System.out.println(toString());
		System.out.println("Adresse : ");
		this.adresse.afficher();
		System.out.println("Créneaux :");
		for(int i = 0; i < nbCreneaux; i++) {
			creneaux[i].afficher();
		}
	}
		
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(nom.toUpperCase());
		builder.append(" "+ prenom);
		builder.append(String.format("%n"));
		builder.append("Téléphone : ");
		builder.append(numTel);
		builder.append(String.format("%n"));
		builder.append("Spécialité : " + specialite);
		builder.append(String.format("%n"));
		builder.append("Tarif : " + tarif + "€");
		builder.append(String.format("%n"));
		
		return builder.toString();
	}
	
	
}
