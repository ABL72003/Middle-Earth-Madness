package characters;

public abstract class MiddleEarthCharacter {

	String name;
	double health;
	double power;
	/**
	 * constructor with no input
	 */
	MiddleEarthCharacter() {
		this.name = "null";
		this.health = 0.0;
		this.power = 0.0;
	}
	/**
	 * constructor with parameters
	 * @param name
	 * @param health
	 * @param power
	 */
	MiddleEarthCharacter(String name, double health, double power) {
		
		this.name = name;
		this.health = health;
		this.power = power;
	}
	/**
	 * this will be defined individually in the character classes but cannot be defined here
	 * @param target
	 * @return
	 */
	public abstract boolean attack(MiddleEarthCharacter target);
	/**
	 * same with this one
	 * @return
	 */
	abstract String getRace();
	/**
	 * display the info of the character
	 */
	
	/**
	 * returns name
	 * @return
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Sets the name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns health
	 * @return
	 */
	public double getHealth() {
		return this.health;
	}
	
	/**
	 * Sets health
	 * @param health
	 */
	public void setHealth(double health) {
		this.health = health;
	}
	
	/**
	 * Returns Power
	 * @return
	 */
	public double getPower() {
		return this.power;
	}
	
	/*
	 * Sets power
	 */
	public void setPower(double power) {
		this.power = power;
	}
	
	/**
	 * Returns true if character equals another
	 * @param other
	 * @return
	 */
	public boolean equals(MiddleEarthCharacter other) {
		if(!(other instanceof MiddleEarthCharacter)) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * Displays info
	 */
	public void displayInfo() {
		System.out.println("name = " + name);
		System.out.println("health = " + health);
		System.out.println("power = " + power); 
	}
}
