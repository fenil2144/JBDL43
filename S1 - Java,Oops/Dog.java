
public final class Dog {
	
	//Instance
	private String name;
	private String breed;
	private String color;
	
	private static int counter;
	
//	{
//		private String age;
//	}
	
	public static void staticMethod() {
		
	}
	
	static {
		counter = 2;
		System.out.println("Static Block executed");
	}
	
//	private final String finalVar;

	
	public String getName() {
		//Local variable
		String age;
		return name;
	}
	
	public final void setName(String name) {
		this.name="Mr."+name;
	}
	
//	private - only class
//	protected - derived class
//	default - Same Package
//	public - everywhere
	
	public Dog() {
		
	}
	
	public Dog(String name,String breed) {
		this.name = name;
		this.breed = breed;
	}
	
	public static void main (String args[]) {
		System.out.println("Before Class");

		Dog tuffy = new Dog("tuffy","papillon");
		
		Dog tom = new Dog();
		System.out.println("In Main Class");
	}

}
