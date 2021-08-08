package Meal;

public class Drink extends Food{
	public Drink(String name, int price) {
		super(name,price);
	}
	public void take() {
		System.out.println("The Drink " + getName() + " is taken");
	}
}
