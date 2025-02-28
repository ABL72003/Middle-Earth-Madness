package characters;

public class Dwarf extends MiddleEarthCharacter {

	public Dwarf(String name, double health, double power) {
		//using super constructor from slides in class
		super(name, health, power);
	}
/**
 * This override checks if Dwarf is attacking an Elf
 * Dwarf gets 1.5 power when doing so
 */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		//1.5 damage
		if (target.getRace().equals("Elf")) {
			target.health -= this.power * 1.5;
			return true;
		}
		//no damage
			else if(target.getRace().equals("Wizard") || target.getRace().equals("Dwarf")) {
			return false;
		}
		//standard damage
			else{
				target.health -= this.power;
				return true;
			}
	}

	@Override
	public String getRace() {
		return "Dwarf";
	}
	
	
}
