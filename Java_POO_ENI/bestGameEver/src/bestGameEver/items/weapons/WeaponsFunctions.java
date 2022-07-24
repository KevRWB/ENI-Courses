package bestGameEver.items.weapons;

public class WeaponsFunctions {
	//Print weapons toString
	public static String toString(Weapon weapon) {
		StringBuilder builder = new StringBuilder();
		builder.append("Weapon [index=");
		builder.append(weapon.getIndex());
		builder.append(", name=");
		builder.append(weapon.getName());
		builder.append(", att=");
		builder.append(weapon.getAtt());
		builder.append(", speed=");
		builder.append(weapon.getSpeed());
		builder.append(", price=");
		builder.append(weapon.getPrice());
		builder.append(", isDistance=");
		builder.append(weapon.getDistance());
		builder.append("]");
		return builder.toString();
	}	
}
