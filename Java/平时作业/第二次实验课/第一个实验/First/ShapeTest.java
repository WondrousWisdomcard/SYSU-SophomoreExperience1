package First;

public class ShapeTest {
	 public static void main(String args[]){
		 Shape shape1 = new Circle(3.0);
		 Shape shape2 = new Cylinder(3.0, 4.0);
		 double sumAreaOfShape = shape1.getArea() + shape2.getArea();
		 System.out.println("Sum area of shape is: " +
		 String.format("%.4f",sumAreaOfShape));
		 System.out.println("The name of shape1 is: " +
		 shape1.getName());
		 System.out.println("The name of shape2 is: " +
		 shape2.getName());
		 System.out.println("");
		 shape1.showDescription();
		 shape2.showDescription();
	 }
}
 