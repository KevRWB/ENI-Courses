package fr.eni.javaee.module6.bo;

public class Voiture {
	private String marque;
	private String modele;
	private String immatriculation;
	private int kilometrage;
	
	//--constructors
	
	public Voiture(String marque, String modele, String immatriculation, int kilometrage) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.immatriculation = immatriculation;
		this.kilometrage = kilometrage;
	}

	public Voiture() {
		super();
	}


	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}


	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}


	public int getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(int kilometrage) {
		this.kilometrage = kilometrage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Voiture [marque=");
		builder.append(marque);
		builder.append(", modele=");
		builder.append(modele);
		builder.append(", immatriculation=");
		builder.append(immatriculation);
		builder.append(", kilometrage=");
		builder.append(kilometrage);
		builder.append("]");
		builder.append("\n");
		return builder.toString();
	}
	
	
	
	
	
	
	
}
