public class Polynomial {
	private double a;
	private double b;
	private double c;
		
	
	public Polynomial(double a, double b, double c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public void setA(double a)
	{
		this.a = a;
	}
	public void setB(double b)
	{
		this.b = b;
	}
	public void setC(double c)
	{
		this.c = c;
	}
	public void showPolynomial()
	{
		System.out.println("F(x)="+ a + "x^2+" + b + "x+" + c);
	}
	public double getY(double x)
	{
		return a * x * x + b * x + c;
	}
	public boolean hasSolution(double y)
	{
		double aa = a;
		double bb = b;
		double cc = c - y;
		if( bb * bb - 4 * aa * cc >= 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void showSolution(double y)
	{
		double aa = a;
		double bb = b;
		double cc = c - y;
		if(!hasSolution(y))
		{
			System.out.println("no solution");
		}
		else
		{
			double ans1 = ( 0 - bb + Math.sqrt(bb * bb - 4 * aa * cc ) / ( 2 * a ) );      
			double ans2 = ( 0 - bb - Math.sqrt(bb * bb - 4 * aa * cc ) / ( 2 * a ) );  
			if(ans1 == ans2)
			{
				System.out.println("solution: " + ans1);
			}
			else
			{
				System.out.println("solution: " + ans1 + " , " + ans2);
			}
		}
	}
}
