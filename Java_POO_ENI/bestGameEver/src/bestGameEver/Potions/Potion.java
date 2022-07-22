package bestGameEver.Potions;

public class Potion {
	int index;
	String nom;
	int bonusLife;
	int bonusAtt;
	int bonusDef;
	String shortDescription;
	String description;
	//CONSTRUCTOR
	public Potion(int index, String nom, int bonusLife, int bonusAtt, int bonusDef, String shortDescription) {
		super();
		this.index = index;
		this.nom = nom;
		this.bonusLife = bonusLife;
		this.bonusAtt = bonusAtt;
		this.bonusDef = bonusDef;
		this.shortDescription = shortDescription;
	}
	//GETTERS SETTERS
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getBonusLife() {
		return bonusLife;
	}
	public void setBonusLife(int bonusLife) {
		this.bonusLife = bonusLife;
	}
	public int getBonusAtt() {
		return bonusAtt;
	}
	public void setBonusAtt(int bonusAtt) {
		this.bonusAtt = bonusAtt;
	}
	public int getBonusDef() {
		return bonusDef;
	}
	public void setBonusDef(int bonusDef) {
		this.bonusDef = bonusDef;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
