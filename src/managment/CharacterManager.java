package managment;

import characters.MiddleEarthCharacter;

public class CharacterManager {
	
	MiddleEarthCharacter[] characters;
	
	int size;
	
	boolean addCharacter(MiddleEarthCharacter c) {
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
		/**
		 * Dynamically resizes the array if it is full. Adds characters to list.
		 */
	}
	
	
	MiddleEarthCharacter getCharacter(String name) {
		for(MiddleEarthCharacter character : characters) {
			if(character.getName() == name) {
				return character;
			}
			
		}
		return null;
		/**
		 * gets a character based on using for/each loop and checking using equals() operation.
		 */
	}
	
	boolean updateCharacter(MiddleEarthCharacter character, String name, int health, int power) {
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
		
		/**
		 * checks if there is a change of each attribute and updates it individually.
		 */
	}
	
	boolean deleteCharacter(MiddleEarthCharacter character) {
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
		/**
		 * finds index of character object, then removes it from the list by shifting each object index to one less.
		 */
	}
	
	void displayAllCharacters() {
		for(int i = 0;i<size ; i++) {
			characters[i].displayInfo();
			}
			return;
			
			/**
			 * uses a for loop to display each character object.
			 */
		}
	
	private int findIndex(MiddleEarthCharacter character) {
		for(int i = 0;i<characters.length; i++) {
			if(characters[i].equals(character)){
				return i;
			}
		}
		return -1;
		
		/**
		 * uses a for and if loop to find the index of character passed.
		 */
	}
	
	
}


