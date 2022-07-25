package bestGameEver.items;

public class Item {
	protected int index;
	protected String name;
	protected String shortDescription;
	protected String description;
	protected int price;
	protected double weight;
	//CONSTRUCTOR
	public Item(int index, String nom, String shortDescription, String description, int price, double weight) {

		this.index = index;
		this.name = nom;
		this.shortDescription = shortDescription;
		this.description = description;
		this.price = price;
		this.weight = weight;
	}
	//GETTERS / SETTERS
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	

	
}
