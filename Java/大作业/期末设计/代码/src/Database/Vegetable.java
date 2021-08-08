package Database;

public class Vegetable extends Cuisine {
	private String attribute = "Êß²Ë";

	public Vegetable(String name, int num, String icon, double price, String ID) {
		this.seticon(icon);
		this.setID(ID);
		this.setname(name);
		this.setnum(num);
		this.setprice(price);
	}
}
