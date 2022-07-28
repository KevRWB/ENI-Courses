package poo.exoUn;

public class Article {

	private String ref;
	private String designation;
	private int prix;
	//Constructor
	public Article(String ref, String designation, int prix) {
		this.ref = ref;
		this.designation = designation;
		this.prix = prix;
	}
	//GETTERS SETTERS
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	//StringBuilder
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Article - ref :");
		builder.append(ref);
		builder.append(", designation=");
		builder.append(designation);
		builder.append(", prix=");
		builder.append(prix);
		builder.append("]");
		return builder.toString();
	}

	
	
	

}
