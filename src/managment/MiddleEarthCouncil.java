package managment;

public class MiddleEarthCouncil {
	
	private static MiddleEarthCouncil instance;
	
	private MiddleEarthCouncil() {
		
	}
	
	static MiddleEarthCouncil getInstance(){
		if(instance == null) {
		instance = new MiddleEarthCouncil();
		}
		
		return instance;
	}
	
}
