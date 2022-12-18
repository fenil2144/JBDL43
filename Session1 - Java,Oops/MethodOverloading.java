
public class MethodOverloading {
	
	
	public double sum(int x, int y) {
		return x+y;
	}
	
	public double sum(double x,double y,double z) {
		return x+y+z;
	}
	
	public int sum(int a, int b, int c) {
		return a+b+c;
	}
	
	public static void main(String args[]) {
		MethodOverloading obj = new MethodOverloading();
		System.out.println(obj.sum(1, 2,3));
		System.out.println(obj.sum(1.0,2.0,3.0));
//		System.out.println(obj.sum(1.0,2.0));
		
	}

}
