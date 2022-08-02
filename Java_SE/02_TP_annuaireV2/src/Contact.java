
public class Contact {
	private String nom;
	private String numTel;
	//CONSTRUCTORS
	public Contact() {
	}
	public Contact(String nom, String numTel) {
		this.nom = nom;
		this.numTel = numTel;
	}
	//GET/SET
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNumTel() {
		return numTel;
	}
	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}
	//ToSTRING
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contact [nom=");
		builder.append(nom);
		builder.append(", numTel=");
		builder.append(numTel);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
