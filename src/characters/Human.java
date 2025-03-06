package characters;

public class Human extends MiddleEarthCharacter {

	/**
	 * Creates human
	 * @param name
	 * @param health
	 * @param power
	 */
	public Human(String name, double health, double power) {
		//using super constructor from slides in class
		super(name, health, power);
	}
/**
 * This override checks if Human is attacking an Wizard
 * Elf gets 1.5 power when doing so
 */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		//1.5 damage
		if (target.getRace().equals("Wizard")) {
			target.health -= this.power * 1.5;
			return true;
		}
		//no damage
			else if(target.getRace().equals("Orc") || target.getRace().equals("Human")) {
			return false;
		}
		//standard damage
			else{
				target.health -= this.power;
				return true;
			}
	}
	/**
	 * returns race
	 */
	@Override
	public String getRace() {
		return "Human";
	}
	
	
}
