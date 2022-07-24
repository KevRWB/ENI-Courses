package bestGameEver.races;

public class Race {
	protected String name;
	protected String description;
	protected int bonusAtt;
	protected int bonusDef;
	protected int bonusSpeed;
	protected int bonusDodge;
	protected int bonusLife;
	protected int bonusInitiative;
	//CONSTRUCTOR
	public Race(String name, String description, int bonusAtt, int bonusDef, int bonusSpeed, int bonusDodge,
			int bonusLife, int bonusInitiative) {
		super();
		this.name = name;
		this.description = description;
		this.bonusAtt = bonusAtt;
		this.bonusDef = bonusDef;
		this.bonusSpeed = bonusSpeed;
		this.bonusDodge = bonusDodge;
		this.bonusLife = bonusLife;
		this.bonusInitiative = bonusInitiative;
	}
	
	
}
