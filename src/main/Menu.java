package main;

import characters.Dwarf;
import characters.Elf;
import characters.Human;
import characters.Orc;
import characters.Wizard;
import managment.CharacterManager;
import managment.MiddleEarthCouncil;
import characters.MiddleEarthCharacter;

public class Menu {
	private CharacterManager characterManager; // Declare the council as a private field

	/**
	 * Initializes the instance of characterManager
	 */
    public Menu() {
        // Initialize the council using the singleton getInstance() method
        characterManager = MiddleEarthCouncil.getInstance().getCharacterManager();
    }
    
    /**
     * Displays menu
     */
    public void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Add a new character");
        System.out.println("2. View all characters");
        System.out.println("3. Update a character");
        System.out.println("4. Delete a character");
        System.out.println("5. Execute all characters' attack actions");
        System.out.println("6. Exit");
    }

    /**
     * Adds a character. 
     * @param name
     * @param health
     * @param power
     * @param raceChoice
     */
    public void addCharacter(String name, double health, double power, int raceChoice) {
        MiddleEarthCharacter character = null;

        switch (raceChoice) {
            case 1: 
                character = new Elf(name, health, power);
                break;
            case 2:
                character = new Dwarf(name, health, power);
                break;
            case 3:
                character = new Human(name, health, power);
                break;
            case 4:
                character = new Orc(name, health, power);
                break;
            case 5:
                character = new Wizard(name, health, power);
                break;
            default:
                System.out.println("Invalid race selection.");
                return;
        }

        if (character != null && characterManager.addCharacter(character)) {
            System.out.println("Character added successfully: " + character.getName());
        } else {
            System.out.println("Failed to add character.");
        }
    }
    
    /**
     * Updates a given character. If character isn't found, doesn't update
     * @param nameToFind
     * @param newName
     * @param newHealth
     * @param newPower
     */
    public void updateCharacter(String nameToFind, String newName, double newHealth, double newPower) {
        MiddleEarthCharacter characterToFind = characterManager.getCharacter(nameToFind);

        if (characterToFind == null) {
            System.out.println("Character not found.");
            return;
        }

        boolean updated = characterManager.updateCharacter(characterToFind, newName, (int)newHealth, (int)newPower);

        if (updated) {
            System.out.println("Character updated successfully!");
        } else {
            System.out.println("No changes made.");
        }
    }

    /**
     * Deletes a character with a given name. If the name is not in the list, nothing deletes
     * @param nameToDelete
     */
    public void deleteCharacter(String nameToDelete) {
        MiddleEarthCharacter characterToDelete = characterManager.getCharacter(nameToDelete);

        if (characterToDelete == null) {
            System.out.println("Character not found.");
            return;
        }

        boolean deleted = characterManager.deleteCharacter(characterToDelete);

        if (deleted) {
            System.out.println("Character deleted successfully!");
        } else {
            System.out.println("Failed to delete character.");
        }
    }
    
    /**
     * Every player executes an attack 
     */
    public void executeAttacks() {
        MiddleEarthCharacter[] characters = characterManager.getCharacters();

        // Loop through each character and attack the next character in order
        for (int i = 0; i < characterManager.getSize(); i++) {
            MiddleEarthCharacter attacker = characters[i];

            // The target is the next character in the array, wrapping around to the first if necessary
            MiddleEarthCharacter target = characters[(i + 1) % characterManager.getSize()];

            // Execute the attack
            boolean attackSuccess = attacker.attack(target);

            // Display the result
            if (attackSuccess) {
                System.out.println(attacker.getName() + " successfully attacked " + target.getName());
            } else {
                System.out.println(attacker.getName() + " failed to attack " + target.getName());
            }
        }
    }

    /**
     * Displays all the characters
     */
    public void displayAllCharacters() {
        characterManager.displayAllCharacters();
    }
}
