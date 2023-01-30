public class InterfaceExample implements cat,dog1{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void walk() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eat(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		cat.super.run();
	}
	
}


interface cat{
	public void eat();
	public void walk();
	public default void run() {
		
	}
	
//	public default void sleep(){
//		System.out.println("Sleeping");
//	}
}

interface dog1{
	public void eat(String name);
	public void sleep();
	
	public default void run() {
		
	}
	
//	public default void sleep(){
//		System.out.println("Sleeping");
//	}
}