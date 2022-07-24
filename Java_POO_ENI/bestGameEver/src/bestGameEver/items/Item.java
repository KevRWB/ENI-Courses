package bestGameEver.items;

public class Item {
	protected int index;
	protected String nom;
	protected String shortDescription;
	protected String description;
	protected int price;
	protected int weight;
	//CONSTRUCTOR
	public Item(int index, String nom, String shortDescription, String description, int price, int weight) {

		this.index = index;
		this.nom = nom;
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
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
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
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
