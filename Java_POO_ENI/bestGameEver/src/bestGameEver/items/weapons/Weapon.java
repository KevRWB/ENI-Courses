package bestGameEver.items.weapons;

public class Weapon {
	private int index;
	private String name;
	private int att;
	private int speed;
	private int price;
	private boolean isDistance;
	private int distance;
	//CONSTRUCTOR
	public Weapon(int index, String name, int att, int speed, int price, boolean isDistance, int distance) {
		super();
		this.index= index;
		this.name = name;
		this.att = att;
		this.speed = speed;
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
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
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
}
