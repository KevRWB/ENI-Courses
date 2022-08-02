import java.util.ArrayList;

public class Annuaire {
	
	private ArrayList<Contact> annuaire = new ArrayList<>();
	//	CONSTRUCTOR
	public Annuaire() {
	}
	//METHODS
	public void addContact(String name, String num) {
		annuaire.add(new Contact(name, num));
	}
	public void rechercheContact(String name) {
		for(Contact contact : annuaire) {
			if(contact.getNom() == name) {
				System.out.println(contact);
				break;
			}
		}
	}
	public void delContact(String nom) {
		
	}
	
	
	//GET / SET
	public ArrayList<Contact> getAnnuaire() {
		return annuaire;
	}
	public void setAnnuaire(ArrayList<Contact> annuaire) {
		this.annuaire = annuaire;
	}
	
	
	
	
	
	
}
