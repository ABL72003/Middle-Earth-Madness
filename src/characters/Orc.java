package characters;

public class Orc extends MiddleEarthCharacter {

	public Orc(String name, double health, double power) {
		//using super constructor from slides in class
		super(name, health, power);
	}
/**
 * This override checks if Orc is attacking an Human
 * Elf gets 1.5 power when doing so
 */
	@Override
	public boolean attack(MiddleEarthCharacter target) {
		//1.5 damage
		if (target.getRace().equals("Human")) {
			target.health -= this.power * 1.5;
			return true;
		}
		//no damage
			else if(target.getRace().equals("Elf") || target.getRace().equals("Orc")) {
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
		return "Orc";
	}
	
	
}
