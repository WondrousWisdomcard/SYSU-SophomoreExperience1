package First;

public class Cylinder extends Shape{
	private double radius;
	private double height;
	
	Cylinder(double radius, double height)
	{
		super("Cylinder");
		this.height = height;
		this.radius = radius;
	}
	
	public double getHeight()
	{
		return height;
	}
	public void setHeight(double height)
	{
		this.height = height;
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
		return Math.PI * radius * radius * 2 + 2 * radius * Math.PI * height;
	}
	public double getVolume()
	{
		return Math.PI * radius * radius * height;
	}
	
	public void showDescription()
	{
		System.out.println("Shape: " + name);
		System.out.format("radius: %.4f\n",radius);
		System.out.format("height: %.4f\n",height);
		System.out.format("Area: %.4f\n",getArea());
		System.out.format("Volume: %.4f\n",getVolume());
	}
}
