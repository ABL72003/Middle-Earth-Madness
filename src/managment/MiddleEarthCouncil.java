package managment;

public class MiddleEarthCouncil {
	
	private static MiddleEarthCouncil instance;
	private static CharacterManager characterManager;
	
	/**
	 * Private constructor prevents instantiation from other classes 
	 */
	private MiddleEarthCouncil() {
		
	}
	
	/**
	 * Public method to provide access to the instance
	 */
	public static MiddleEarthCouncil getInstance(){
		if(instance == null) {
			instance = new MiddleEarthCouncil();
		}
		
		return instance;
	}
	
	/**
	 * public method to provide access to the instance of characterManager
	 */
	public CharacterManager getCharacterManager() {
		if(characterManager == null) {
			characterManager = new CharacterManager();
		}
		
		return(characterManager);
	}
	
}
