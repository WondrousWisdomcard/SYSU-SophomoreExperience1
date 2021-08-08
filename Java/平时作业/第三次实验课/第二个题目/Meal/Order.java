package Meal;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private List<Food> foodList = new ArrayList<Food>();
	private int peopleAmount;
	private int index;
	
	public Order(int peopleAccount) {
		this.peopleAmount = peopleAccount;
		index = 0;
	}
	public void addFood(Food newFood) {
		foodList.add(newFood);
		System.out.println("The food \""+ newFood.getName() + "\" is added to the order");
	}
	public void setPeopleAmount(int peopleAmount) {
		this.peopleAmount = peopleAmount;
	}
	public void showBill() {
		int sum = 0;
		System.out.println();
		System.out.println("Bill of the Order:");
		for(Food i : foodList) {
			sum += i.getPrice();
			System.out.println("name: " + i.getName() + ", price: " + i.getPrice() + " yuan");
		}
		try {
			if(peopleAmount <= 0) {
				throw new ArithmeticException();
			}
			System.out.println("Each Person should pay: " + sum/peopleAmount + " yuan");
		}
		catch(ArithmeticException e) {
			System.out.println("Error: Should be more than one person pay for the bill");
		}
		System.out.println();
	}
	public void takeFood() {
		try {
			if(index == foodList.size()) {
				throw new Exception();
			}
		foodList.get(index++).take();
		}
		catch(Exception e) {
			System.out.println("Error: All the food have already taken");
		}
	}
}
