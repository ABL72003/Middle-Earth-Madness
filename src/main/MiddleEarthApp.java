package main;

public class MiddleEarthApp {

	public static void main(String[] args) {
		 // Create the Menu object
        Menu menu = new Menu();

        // menu display
        menu.displayMenu();

        // user choosing option 1 (Add a new character)
        System.out.println("\n Add a new character");
        menu.addCharacter("Hermione", 100.0, 75.0, 1); // Elf

        // user choosing option 2 (View all characters)
        System.out.println("\n View all characters");
        menu.displayAllCharacters();

        // user choosing option 5 (Execute all characters' attack actions)
        System.out.println("\n Execute all characters' attack actions");
        menu.executeAttacks();

        //user choosing option 3 (Update a character)
        System.out.println("\n Update character");
        menu.updateCharacter("Hermione", "Hermione Granger", 120.0, 90.0);

        // user choosing option 2 (View all characters again)
        System.out.println("\n View all characters after update");
        menu.displayAllCharacters();

        //user choosing option 4 (Delete a character)
        System.out.println("\n Delete character");
        menu.deleteCharacter("Draco");

        // user choosing option 2 (View all characters after deletion)
        System.out.println("\n View all characters after deletion");
        menu.displayAllCharacters();

        // user choosing option 6 (Exit)
        System.out.println("\n Exit");
    }
}
