package fr.eni.blagues.ihm.controller;

import java.util.ArrayList;
import java.util.List;

import fr.eni.blagues.bll.BLLException;
import fr.eni.blagues.bll.BlagueManager;
import fr.eni.blagues.bo.Blague;
import fr.eni.blagues.ihm.vue.EcranAddBlague;
import fr.eni.blagues.ihm.vue.EcranNoteBlague;

public class BlagueController {
	BlagueManager blagueManager = BlagueManager.getInstance();
	private Blague blagueActive;
	
	//SINGLETON
	private static BlagueController instance;
	
	private BlagueController() { }
	
	public static BlagueController getInstance() {
		if(instance == null) {
			instance = new BlagueController();
		}
		return instance;
	}
	//FIN SINGLETON
	
	//Pattern Observer
	public interface BlagueControllerListener {
		void printBlagueActive();
		void updateData();
	}
	
	private List<BlagueControllerListener> listeners = new ArrayList<>();
	public void addListener(BlagueControllerListener listener) {
		this.listeners.add(listener);
	}
	//Fin pattern Observer
	
	//METHODS
	public  Blague getBlagueTopUn() throws BLLException {
		Blague blagueSelected = blagueManager.selectTopUn();
		blagueActive = blagueSelected;
		return blagueSelected;
	}
	
	public void insert(Blague blague) throws BLLException {
		blagueActive = blague;
		blagueManager.insert(blague);
	}
	
	public void update(Blague blague)  throws BLLException{
		blagueManager.update(blague);
		notifyUpdate();
	}
	//Getters setters
	public Blague getBlagueActive() {
		return blagueActive;
	}

	public void setBlagueActive(Blague blagueActive) {
		this.blagueActive = blagueActive;
	}

	public List<Blague> getAllBlagues() throws BLLException {
		return blagueManager.selectAll();
	}
	
	//Methods Ecran accueil
	public void openEcranNoteBlague() {
		EcranNoteBlague ecranNoteBlague = new EcranNoteBlague();
	}
	public void openEcranAddBlague() {
		EcranAddBlague ecranAddBlague = new EcranAddBlague();
	}
	
	//Methods listener
	public void preventOnTableClick() {
		for(BlagueControllerListener listener : listeners) {
			listener.printBlagueActive();
		}
	}
	public void notifyUpdate() {
//		for(BlagueControllerListener listener : listeners) {
//			listener.updateData();
//		}
		listeners.forEach(l -> l.updateData());
	}
	

	
	
}
