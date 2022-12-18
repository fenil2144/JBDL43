import java.io.IOException;

abstract class A{
	
}


public class ExceptionDemo {
	
	public static void main(String args[]) {
		computeDivision(0);
//		A obj = new A();
		try {
			computeDivision(10);
			//"checking input from user"
			if(true) {
				throw new ArithmeticException();
			}
			System.exit(0);
			computeDivision(0);
		}

		catch(ArithmeticException | NullPointerException e) {
			System.out.println("I am in catching Arithmetic Exception");
		}
//		catch (NullPointerException e) {
//			int a =10;
//			System.out.println(e.getLocalizedMessage());
//		}
		catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		finally{
			System.out.println("I am in Finally Block");
		}
		
		System.out.println("Rest of the Code");
	}
	
	public static void computeDivision(int number) throws ArithmeticException{
		int x = 100/number;
		System.out.println("X = "+x);
	}

}
