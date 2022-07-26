package bestGameEver.items.weapons;

import bestGameEver.items.Item;

public class Weapon extends Item {
	private int index;
	private int att;
	private int speed;
	private boolean isDistance;
	private int distance;
	private static int nbWeapons;
	//INIT METHODS
		static {
			nbWeapons = 1;
		}
	//CONSTRUCTOR
	public Weapon(String name, String shortDescription, String description, int price, int weight, int att, int speed, boolean isDistance, int distance) {
		super(name, shortDescription, description, price, weight );
		this.att = att;
		this.speed = speed;
		this.isDistance = isDistance;
		this.distance = distance;
		index = nbWeapons;
		nbWeapons ++;
	}
	
	//METHODS 
	
	//PRINT
	public void afficher() {
		System.out.println(toString());
	}
	//toString METHOD
	@Override
 	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("- "+ name.toString() + " - ");
		builder.append(String.format("%n"));
		builder.append("Attaque : ");
		builder.append(att);
		builder.append("   Vitesse : ");
		builder.append(speed);
		if(isDistance) {
			builder.append("Distance : ");
			builder.append(distance);
		}
		builder.append(String.format("%n"));
		if(shortDescription != null) {
			builder.append(", shortDescription=");
			builder.append(shortDescription);
			builder.append(String.format("%n"));
		}
		if(description != null) {
			builder.append(", description=");
			builder.append(description);
			builder.append(String.format("%n"));
		}
		builder.append("Poids : ");
		builder.append(weight);
		builder.append("kg");
		builder.append(String.format("%n"));
		return builder.toString();
	}
	// GETTERS / SETTERS
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAtt() {
		return att;
	}
	public void setAtt(int att) {
		this.att = att;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public boolean isDistance() {
		return isDistance;
	}
	public void setDistance(boolean isDistance) {
		this.isDistance = isDistance;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	

}
