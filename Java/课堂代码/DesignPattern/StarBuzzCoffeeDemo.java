public class StarBuzzCoffeeDemo {

	public static void main(String arg[]) {

		Coffee coffer = new SimpleCoffee();
		coffer = new WithMilk(coffer);
		System.out.println(coffer.getCost() + "$  " + coffer.getIngredients());
		coffer = new WithSprinkles(coffer);
		System.out.println(coffer.getCost() + "$  " + coffer.getIngredients());
	}
}

interface Coffee {
	public double getCost();

	public String getIngredients();
}

 class SimpleCoffee implements Coffee {
	@Override
	public double getCost() {
		return 1;
	}

	@Override
	public String getIngredients() {
		return "Coffee";
	}
}

 class BlackCoffee implements Coffee {
	@Override
	public double getCost() {
		return 2;
	}

	@Override
	public String getIngredients() {
		return "BlackCoffee";
	}
}

 abstract class CoffeeDecorator  implements Coffee {
	private final Coffee decoratedCoffee;

	public CoffeeDecorator (Coffee c) {
		this.decoratedCoffee = c;
	}

	@Override
	public double getCost() {
		return decoratedCoffee.getCost();
	}

	@Override
	public String getIngredients() {
		return decoratedCoffee.getIngredients();
	}
}

class WithMilk extends CoffeeDecorator  {
	public WithMilk(Coffee c) {
		super(c);
	}

	@Override
	public String getIngredients() {
		return super.getIngredients() + ", Milk";
	}
}

class WithSprinkles extends CoffeeDecorator  {
	public WithSprinkles(Coffee c) {
		super(c);
	}

	@Override
	public double getCost() {
		return super.getCost() + 0.2;
	}

	@Override
	public String getIngredients() {
		return super.getIngredients() + ", Sprinkles";
	}
}
