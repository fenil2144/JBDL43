package Session3;

@FunctionalInterface
interface MyInterface{
	
	public int getSum(int a, int b);
	
	default void printString() {
		System.out.println("I am default Method");
	}
}

class MyInterfaceImpl implements MyInterface{

	@Override
	public int getSum(int a, int b) {
		// TODO Auto-generated method stub
		return a+b;
	}
	
	public void Demo(MyInterface myObj) {
		
	}
}

public class FunctionalInterfaceTest {
	public static void main(String args[]) {
		
		MyInterfaceImpl obj = new MyInterfaceImpl();
		System.out.println(obj.getSum(20, 30));
		
		
		MyInterface interfObj = new MyInterface() {
			
			@Override
			public int getSum(int a, int b) {
				return a+b;
				//rest of code
			}
		};
		System.out.println(interfObj.getSum(20, 30));
		
//		MyInterface interfObj = new MyInterface();
		
//		obj.Demo(interfObj);
		
		//(Argument list) -> { Body };
		MyInterface interfaceLambda = (a,b) -> {return (a+b);
		//rest of code
		};
		System.out.println(interfaceLambda.getSum(20, 30));

	}

}
