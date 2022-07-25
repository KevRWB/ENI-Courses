package bestGameEver.items.potions;

import bestGameEver.items.Item;

public class Potion extends Item {
	
	private int bonusLife;
	private int bonusDef;
	private int bonusAtt;

	//CONSTRUCTOR
	public Potion(int index, String nom, String shortDescription, String description, int price, int weight,
			int bonusLife, int bonusDef, int bonusAtt) {
		super(index, nom, shortDescription, description, price, weight);
		this.bonusLife = bonusLife;
		this.bonusDef = bonusDef;
		this.bonusAtt = bonusAtt;
	}
	//AFFICHER
	//Afficher potion
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("Index=");
		builder.append(index);
		builder.append(", nom=");
		builder.append(name);
		builder.append(", shortDescription=");
		builder.append(shortDescription);
		builder.append(", description=");
		builder.append(description);
		builder.append(", price=");
		builder.append(price);
		builder.append(", weight=");
		builder.append(weight + " ");
		builder.append("bonusLife=");
		builder.append(bonusLife);
		builder.append(", bonusDef=");
		builder.append(bonusDef);
		builder.append(", bonusAtt=");
		builder.append(bonusAtt);
		return builder.toString();
	}
	//GETTERS SETTERS
	public int getBonusLife() {
		return bonusLife;
	}
	public void setBonusLife(int bonusLife) {
		this.bonusLife = bonusLife;
	}
	public int getBonusDef() {
		return bonusDef;
	}
	public void setBonusDef(int bonusDef) {
		this.bonusDef = bonusDef;
	}
	public int getBonusAtt() {
		return bonusAtt;
	}
	public void setBonusAtt(int bonusAtt) {
		this.bonusAtt = bonusAtt;
	}
}
