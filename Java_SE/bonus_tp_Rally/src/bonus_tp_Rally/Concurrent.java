package bonus_tp_Rally;

public class Concurrent {
	private String nom, prenom, nationalite;
	//constructor
	public Concurrent(String nom, String prenom, String nationalite) {
		this.nom = nom;
		this.prenom = prenom;
		this.nationalite = nationalite;
	}

	//toString
	public String infosConcurrent() {
		StringBuilder builder = new StringBuilder();
		builder.append("Concurrent [nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", nationalite=");
		builder.append(nationalite);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
