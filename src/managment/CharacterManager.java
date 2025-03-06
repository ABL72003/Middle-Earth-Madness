package managment;

import characters.MiddleEarthCharacter;

public class CharacterManager {

    private MiddleEarthCharacter[] characters = new MiddleEarthCharacter[10]; // Initial array capacity
    private int size = 0;

    public boolean addCharacter(MiddleEarthCharacter c) {
        if (size >= characters.length) { // Resize array if full
            MiddleEarthCharacter[] newArray = new MiddleEarthCharacter[characters.length * 2];
            System.arraycopy(characters, 0, newArray, 0, characters.length);
            characters = newArray;
        }

        characters[size] = c;
        size++;
        return true;
    }

    public MiddleEarthCharacter getCharacter(String name) {
        for (int i = 0; i < size; i++) {
            if (characters[i].getName().equals(name)) { // Use .equals() for string comparison
                return characters[i];
            }
        }
        return null;
    }

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

    public boolean deleteCharacter(MiddleEarthCharacter character) {
        int index = findIndex(character);
        if (index == -1) return false;

        for (int i = index; i < size - 1; i++) {
            characters[i] = characters[i + 1];
        }
        characters[size - 1] = null; // Clear last element
        size--;
        return true;
    }

    public void displayAllCharacters() {
        for (int i = 0; i < size; i++) {
            characters[i].displayInfo();
        }
    }

    private int findIndex(MiddleEarthCharacter character) {
        for (int i = 0; i < size; i++) { // Loop through valid elements
            if (characters[i].equals(character)) {
                return i;
            }
        }
        return -1;
    }
}
