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
	abstract boolean attack(MiddleEarthCharacter target);
	/**
	 * same with this one
	 * @return
	 */
	abstract String getRace();
	/**
	 * display the info of the character
	 */
	void displayInfo() {
		System.out.println("name = " + name);
		System.out.println("health = " + health);
		System.out.println("power = " + power); 
	}
}
