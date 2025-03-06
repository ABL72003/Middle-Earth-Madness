package managment;

import characters.MiddleEarthCharacter;

public class CharacterManager {
	
	private MiddleEarthCharacter[] characters = new MiddleEarthCharacter[3]; //initial array capacity
	
	private int size = 0;
	
	/**
	 * Dynamically resizes the array if it is full. Adds characters to list.
	 */
	public boolean addCharacter(MiddleEarthCharacter c) {		
		// Check if the character already exists in the list based on the name (or another unique property)
	    for (int i = 0; i < size; i++) {
	        if (characters[i] != null && characters[i].getName().equals(c.getName())) {
	            // Character already exists, do not add it
	            System.out.println("Character with name " + c.getName() + " already exists.");
	            return false;
	        }
	    }
		
		if (size >= characters.length) {//resize array if full
			MiddleEarthCharacter[] newArray = new MiddleEarthCharacter[characters.length*2];
			
			System.arraycopy(characters, 0, newArray, 0, characters.length);
			characters = newArray;
		}
		
		characters[size] = c;
		size++;
		return true;	
	}
	
	/**
	 * gets a character based on using for/each loop and checking using equals() operation.
	 */
	public MiddleEarthCharacter getCharacter(String name) {
		for(int i = 0; i < size; i++) {
			
			if(characters[i].getName().equals(name)) {//use .equals() for string comparison
				return characters[i];
			}
		}
		return null;
	}
	
	/**
	 * checks if there is a change of each attribute and updates it individually.
	 */
	public boolean updateCharacter(MiddleEarthCharacter character, String name, int health, int power) {
		boolean change = false;
        if (!character.getName().equals(name)) {
            character.setName(name);
            change = true;
        }
        if ((int) character.getHealth() != health) {
            character.setHealth(health);
            change = true;
        }
        if ((int) character.getPower() != power) {
            character.setPower(power);
            change = true;
        }
        return change;	
	}

	/**
	 * Finds index of character object, then removes it from the list by shifting each object index to one less.
	 */
	public boolean deleteCharacter(MiddleEarthCharacter character) {
		if (character == null) {
	        System.out.println("Cannot delete a null character.");
	        return false;
	    }

	    int index = findIndex(character);
	    if (index == -1) {
	        System.out.println("Character not found.");
	        return false;
	    }

	    System.out.println("Deleting: " + characters[index].getName()); 

	    // Shift elements left
	    for (int i = index; i < size - 1; i++) {
	        characters[i] = characters[i + 1];
	    }

	    characters[size - 1] = null; // Clear last reference
	    size--; // Reduce size

	    return true;
	}
	
	/**
	 * Uses a for loop to display each character object.
	 */
	public void displayAllCharacters() {
		for(int i = 0;i<size ; i++) {
			characters[i].displayInfo();
			}
		}
	
	/**
	 * uses a for and if loop to find the index of character passed.
	 */
	private int findIndex(MiddleEarthCharacter character) {
		for(int i = 0;i<characters.length; i++) {
			if(characters[i].equals(character)){
				return i;
			}
		}
		return -1;
	}
	
	
	/**
	 * returns the size of the characters array 
	 * @return
	 */
    public int getSize() {
        return size;
    }
    
    /**
     * returns array of characters
     * @return
     */
    public MiddleEarthCharacter[] getCharacters() {
        return characters;
    }
}
