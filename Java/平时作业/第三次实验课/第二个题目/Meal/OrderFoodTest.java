package Meal;

public class OrderFoodTest { 
	public static void main(String args[]) { 
		Order order = new Order(0);
		
		order.addFood(new Drink("Coke",4));
		order.addFood(new Drink("Coffee",10));
		order.addFood(new Drink("Juice",6));
		order.addFood(new Drink("Tea",5));
		order.addFood(new Dishes("tofu",15));
		order.addFood(new Dishes("stir-fried vegetable",20));
		order.addFood(new Dishes("fried chicken",30));
		order.addFood(new Dishes("streamed fished",35));
		order.showBill();
		
		order.setPeopleAmount(4);
		order.addFood(new Dishes("Chow mein",35));
		order.showBill();
		
		for(int i=0;i<10;i++){ 
			order.takeFood(); 
		}
	}
}