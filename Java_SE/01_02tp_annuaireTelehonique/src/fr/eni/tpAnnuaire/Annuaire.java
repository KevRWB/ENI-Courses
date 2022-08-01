package fr.eni.tpAnnuaire;

import java.util.HashMap;
import java.util.Map;

public class Annuaire {
	
	private Map<String, Contact> listAnnuaire = new HashMap<>();
	
	//-------------
	public void ajouterContact(String nom, String num) {
		listAnnuaire.put(nom, new Contact(nom, num));
	}
	
	public void supprimerContact(String nom) {
		listAnnuaire.remove(nom);
	}
	
	public void modifierTel(String nom, String num) {
		listAnnuaire.get(nom).setNumeroTel(num);;
	}
	
	public String afficherContact(String nom) {
		return listAnnuaire.get(nom).toString();
	}

	
	
	public Map<String, Contact> getListAnnuaire() {
		return listAnnuaire;
	}

	public void setListAnnuaire(Map<String, Contact> listAnnuaire) {
		this.listAnnuaire = listAnnuaire;
	}
	
	
	
	
}
