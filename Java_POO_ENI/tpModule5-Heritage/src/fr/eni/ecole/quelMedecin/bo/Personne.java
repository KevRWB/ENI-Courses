package fr.eni.ecole.quelMedecin.bo;

public class Personne {
protected String nom;
protected String prenom;
protected String numTel;
protected Adresse adresse;
public Personne(String nom, String prenom, String numTel
		, Adresse adresse) {
	this.nom = nom;
	this.prenom = prenom;
	this.numTel = numTel;
	this.adresse=adresse;
}

public Adresse getAdresse() {
	return adresse;
}

public void setAdresse(Adresse adresse) {
	this.adresse = adresse;
}

public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getNumTel() {
	return numTel;
}
public void setNumTel(String numTel) {
	this.numTel = numTel;
}

public void afficher() {
	System.out.println(this.toString());
}
@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append(nom.toUpperCase());
	builder.append(" ");
	builder.append(prenom);
	builder.append(String.format("%n"));
	builder.append("Téléphone : ");
	builder.append(numTel);
	return builder.toString();
}

}
