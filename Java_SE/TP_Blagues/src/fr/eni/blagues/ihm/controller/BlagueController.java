package fr.eni.blagues.ihm.controller;

import java.util.ArrayList;
import java.util.List;

import fr.eni.blagues.bll.BLLException;
import fr.eni.blagues.bll.BlagueManager;
import fr.eni.blagues.bo.Blague;

public class BlagueController {
	BlagueManager blagueManager = BlagueManager.getInstance();
	
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
		
	}
	private List<BlagueControllerListener> listeners = new ArrayList<>();
	public void addListener(BlagueControllerListener listener) {
		this.listeners.add(listener);
	}
	//Fin pattern Observer
	
	//METHODS
	public Blague getBlagueTopUn() throws BLLException {
		return blagueManager.selectTopUn();
	}
	
	
}
