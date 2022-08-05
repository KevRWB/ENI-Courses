package bonus_tp_Rally;

public class Equipe {
	private String nom, nationalite;
	private boolean constructeur;
	private Equipage[] equipages = new Equipage[3];
	private int equipageIndex = 0;
	
	//Constructor
	public Equipe(String nom, String nationalite, boolean constructeur) {
		super();
		this.nom = nom;
		this.nationalite = nationalite;
		this.constructeur = constructeur;
	}
	//ajouter equipage a liste d'équipage
	public void ajouterEquipage(Equipage equipage) {
		equipages[equipageIndex] = equipage;
		equipageIndex++;
	}
	public Equipage getEquipage(int dossard) {
		Equipage foundEquipage = null;
		for(Equipage equipage : equipages) {
			if(equipage.getDossard() == dossard) {
				foundEquipage = equipage;
				break;
			}
		}
		return foundEquipage;
	}
	
	//toString
	public String infosEquipe() {
		StringBuilder builder = new StringBuilder();
		builder.append("Equipe [nom=");
		builder.append(nom);
		builder.append(", nationalite=");
		builder.append(nationalite);
		builder.append(", constructeur=");
		builder.append(constructeur);
		builder.append("]");
		return builder.toString();
	}
	
}
