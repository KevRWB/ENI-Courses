package bestGameEver.Potions;

public class PotionsFunctions {
	
	//Afficher potion
	public static String toString(Potion potion) {
		StringBuilder builder = new StringBuilder();
		builder.append("Potion [index=");
		builder.append(potion.index);
		builder.append(", nom=");
		builder.append(potion.nom);
		builder.append(", bonusLife=");
		builder.append(potion.bonusLife);
		builder.append(", bonusAtt=");
		builder.append(potion.bonusAtt);
		builder.append(", bonusDef=");
		builder.append(potion.bonusDef);
		builder.append(", shortDescription=");
		builder.append(potion.shortDescription);
		builder.append(", description=");
		builder.append(potion.description);
		builder.append("]");
		return builder.toString();
	}	
	
}
