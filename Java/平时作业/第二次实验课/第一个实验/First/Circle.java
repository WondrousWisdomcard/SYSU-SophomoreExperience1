package First;

public class Circle extends Shape{
	private double radius;
	
	public Circle(double radius)
	{
		super("Circle");
		this.radius = radius;
	}
	
	public double getRadius()
	{
		return radius;
	}
	public void setRadius(double radius)
	{
		this.radius = radius;
	}
	
	public double getArea()
	{
		return radius * radius * Math.PI;
	}
	public double getPerimeter()
	{
		return 2 * radius * Math.PI;
	}
	
	public void showDescription()
	{
		System.out.println("Shape: " + name);
		System.out.format("radius: %.4f\n",radius);
		System.out.format("Area: %.4f\n",getArea());
		System.out.format("Perimeter: %.4f\n",getPerimeter());
	}
}
