package tpLocationCycles;

public class CycleException extends Exception {

	private static final long serialVersionUID = 1L;
	private Cycle unCycle;
	
	
	//CONSTRUCTORS
	public CycleException(String message, Throwable cause, Cycle cycle) {
		super("Erreur au niveau des cycles :" + message, cause);
		this.unCycle = cycle;
	}
	public CycleException(String message, Cycle cycle) {
		super("Erreur au niveau des cycles :" + message);
		this.unCycle = cycle;
	}

	//GETTER
	public Cycle getUnCycle() {
		return unCycle;
	}
	
	
	
	
	
}
