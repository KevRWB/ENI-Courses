package fr.eni.ecole.quelMedecin.bo;

public class MedecinGeneraliste {
	private String nom;
	private String prenom;
	private String tel;
	
	private static int prixConsult;
	
	// constructeur
	public MedecinGeneraliste(String nom, String prenom, String tel) {
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		
	}
	
	//METHODS
	//Getter numero téléphone
	public String getNumeroDeTelephone() {
		return this.tel;
	}
	//Setter numéro téléphone
	public void setNumeroDeTelephone(String num) {
		this.tel = num;
	}
	//Getter nom
	public String getNom() {
		return this.nom;
	}
	//Setter static tarif
	public static void setTarif(int tarif) {
		MedecinGeneraliste.prixConsult = tarif;
	}
	
	//affichage
	public void afficher() {
		System.out.println(this.nom.toUpperCase() + " " + this.prenom);
		System.out.println("Téléphone : " + this.tel);
		System.out.println("Tarif : " + MedecinGeneraliste.prixConsult + "€");
	}
}
