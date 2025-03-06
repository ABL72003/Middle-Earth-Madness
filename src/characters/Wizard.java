package characters;

public class Wizard extends MiddleEarthCharacter {
	
	/**
	 * Creates a Wizard
	 * @param name
	 * @param health
	 * @param power
	 */
	public Wizard(String name, double health, double power) {
		//using super constructor from slides in class
		super(name, health, power);
	}
/**
 * This override checks if Wizard is attacking an Dwarf
 * Elf gets 1.5 power when doing so
 */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		//1.5 damage
		if (target.getRace().equals("Dwarf")) {
			target.health -= this.power * 1.5;
			return true;
		}
		//no damage
			else if(target.getRace().equals("Human") || target.getRace().equals("Wizard")) {
			return false;
		}
		//standard damage
			else{
				target.health -= this.power;
				return true;
			}
	}

	/**
	 * Returns race of character
	 */
	@Override
	public String getRace() {
		return "Wizard";
	}
	
	
}
