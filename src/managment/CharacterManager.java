package managment;

import characters.MiddleEarthCharacter;

public class CharacterManager {
	
	MiddleEarthCharacter[] characters;
	
	int size;
	
	public boolean addCharacter(MiddleEarthCharacter c) {
		if(characters == null) {
			characters = new MiddleEarthCharacter[1];
			characters[0] = c;
			size++;
			return true;
		}
		if(++size > characters.length) {
			MiddleEarthCharacter[] dummy = characters.clone();
			characters = new MiddleEarthCharacter[characters.length*2];
			int i = 0;
			for(MiddleEarthCharacter character : dummy) {
				character = dummy[i];
				characters[i] = character;
				i++;
			}
			characters[i] = c;
			return true;
			}
		
		characters[size+1] = c;
		return true;
		
	}
	
	public MiddleEarthCharacter getCharacter(String name) {
		for(MiddleEarthCharacter character : characters) {
			if(character.getName() == name) {
				return character;
			}
			
		}
		return null;
	}
	
	public boolean updateCharacter(MiddleEarthCharacter character, String name, int health, int power) {
		boolean change = false;
		if(character.getName() != name) {
			character.setName(name);
			change = true;
		}
		if((int)character.getHealth() != health) {
			change = true;
			character.setHealth(health);
		}
		if((int)character.getPower() != power) {
			change = true;
			character.setPower(power);
		}
		return change;
	}
	
	public boolean deleteCharacter(MiddleEarthCharacter character) {
		int index = -1;
		for(MiddleEarthCharacter dummy : characters) {
			if(dummy.equals(character)) {
				index = findIndex(character);
			}
		}
		if(index != -1) {
			for(int i = index; i<characters.length; i++) {
				characters[i] = characters[i+1];
			}
			return true;
		}
		return false;
	}
	
	public void displayAllCharacters() {
		for(int i = 0;i<size ; i++) {
			characters[i].displayInfo();
			}
			return;
		}
	
	private int findIndex(MiddleEarthCharacter character) {
		for(int i = 0;i<characters.length; i++) {
			if(characters[i].equals(character)){
				return i;
			}
		}
		return -1;
	}
	
	// Add a getter method for size
    public int getSize() {
        return size;
    }
    
    // Getter method for characters
    public MiddleEarthCharacter[] getCharacters() {
        return characters;
    }

}
