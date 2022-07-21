package bestGameEver.weapons;

public class Weapon {
	private String name;
	private int att;
	private int price;
	private boolean isDistance;
	private int distance;
	//CONSTRUCTOR
	public Weapon(String name, int att, int price, boolean isDistance, int distance) {
		super();
		this.name = name;
		this.att = att;
		this.price = price;
		this.isDistance = isDistance;
		this.distance = distance;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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
	//PRINT WEAPON

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("weapons [name=");
		builder.append(name);
		builder.append(", att=");
		builder.append(att);
		builder.append(", price=");
		builder.append(price);
		builder.append(", isDistance=");
		builder.append(isDistance);
		builder.append(", distance=");
		builder.append(distance);
		builder.append("]");
		return builder.toString();
	}

	
	
	
	
	
}
