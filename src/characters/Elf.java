package characters;

public class Elf extends MiddleEarthCharacter {

	public Elf(String name, double health, double power) {
		//using super constructor from slides in class
		super(name, health, power);
	}
/**
 * This override checks if Elf is attacking an Orc
 * Elf gets 1.5 power when doing so
 */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		//1.5 damage
		if (target.getRace().equals("Orc")) {
			target.health -= this.power * 1.5;
			return true;
		}
		//no damage
			else if(target.getRace().equals("Dwarf") || target.getRace().equals("Elf")) {
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
		return "Elf";
	}
	
	
}
