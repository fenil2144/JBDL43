package Session3;

public class SingletonDesign {
	
	//private No-Arg constructor
	//static method that will return single object created
	//only one instance of class
	
	private static SingletonDesign instance;
	private SingletonDesign() {
		
	}
	
	public static SingletonDesign getInstance() {
		if(instance == null) {
			synchronized(SingletonDesign.class) {
				if(instance == null) {
					instance = new SingletonDesign();
				}
			}
			//rest of code
		}
			
		return instance;
	}
	
	public static void main(String args[]) {
		SingletonDesign.getInstance();
		
		SingletonDesign.getInstance();
	}

}
