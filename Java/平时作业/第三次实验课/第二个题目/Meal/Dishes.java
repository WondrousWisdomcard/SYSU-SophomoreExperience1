package Meal;

public class Dishes extends Food{
	public Dishes(String name, int price) {
		super(name,price);
	}
	public void take() {
		System.out.println("The Dishes " + getName() + " is taken");
	}
}
