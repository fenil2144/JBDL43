class Parent{
	int x = 10;
	protected void method1() {
		System.out.println("From Parent Method");
	}
}
class Child extends Parent{
	public void method1() {
		System.out.println("From Child ");
	}
}

class Child2 extends Parent{
	public void method1() {
		System.out.println("From Child2");
	}
}
public class MethodOverriding {
	
	public static void main(String args[]) {
		
		Parent obj1 = new Parent();
		obj1.method1();
		
		Child childObj = new Child();
		childObj.method1();
		
		Parent parentObj2 = new Child();
		parentObj2.method1();
		
//		Child childObj2 = (Child) new Parent();
//		childObj.method1();
		
//		Child childObj3 = new Child2();
		
	}

}
