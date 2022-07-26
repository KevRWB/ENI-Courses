package tpLocationCycles;

import java.time.LocalDate;

public abstract class Gyro extends Cycle implements Autonomie {
	
	protected int autonomie;
	//CONSTRUCTOR
	public Gyro(String marque, String modele, LocalDate dateAchat, 
				int autonomie) {
		super(marque, modele, dateAchat);
		setAutonomie(autonomie);;
	}
	
	//GETTERS SETTERS
	public int getAutonomie() {
		return autonomie;
	}
	public void setAutonomie(int autonomie) {
		this.autonomie = autonomie;
	}

}
