package fr.eni.demo.observer;

import java.util.ArrayList;
import java.util.List;

public class ObjetObservable {

	// PATTERN OBSERVER
	//Interface qui définit les méthodes que devront implémenter les observateurs
	public interface ObservateurObjetObservable {
		void maValeurAChange();
	}
	//Liste de tous les objets qui vont observer celui-là (this)
	private List<ObservateurObjetObservable> observateurs = new ArrayList<>();
	
	//registerListener ou register ou addListener ou bind
	public void ajouterObservateur(ObservateurObjetObservable ooo) {
		observateurs.add(ooo);
	}
	
	//unregisterListener ou unregister ou unbind
	public void retirerObservateur(ObservateurObjetObservable ooo) {
		observateurs.remove(ooo);
	}
	
	//notify ou notifyAll
	public void prevenirTousLesObservateurs() {
		for(ObservateurObjetObservable o : observateurs) {
			o.maValeurAChange();
		}
	}
	// FIN PATTERN OBSERVER
	
	private String maValeur = "Valeur par défaut";

	public String getMaValeur() {
		return maValeur;
	}

	public void setMaValeur(String maValeur) {
		this.maValeur = maValeur;
		//Quand la valeur de 'maValeur' change, prévient tous les observateurs
		prevenirTousLesObservateurs();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ObjetObservable [maValeur=");
		builder.append(maValeur);
		builder.append("]");
		return builder.toString();
	}
	
	
}
