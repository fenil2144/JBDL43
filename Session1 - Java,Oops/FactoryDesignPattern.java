interface Shape{
	void draw();
}

class Circle implements Shape{

	@Override
	public void draw() {
		System.out.println("Drawing Circle");
	}
	
}
class Square implements Shape{

	@Override
	public void draw() {
		System.out.println("Drawing Square");
	}
	
}

class ShapeFactory{
	public Shape getShape(String shapeType) {
		if(shapeType.equalsIgnoreCase("CIRCLE")) {
			return new Circle();
		}
		else if(shapeType.equalsIgnoreCase("SQUARE")) {
			return new Square();
		}
		return null;
	}
}

public class FactoryDesignPattern {
	
	public static void main(String args[]) {
		ShapeFactory shapeFactory = new ShapeFactory();
		
		Shape shape1 = shapeFactory.getShape("CIRCLE");
		shape1.draw();
		
		Shape shape2 = shapeFactory.getShape("SQUARE");
		shape1.draw();
	}

}
