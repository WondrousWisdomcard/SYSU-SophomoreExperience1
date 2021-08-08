package Database;

public class Snack extends Cuisine {
	private String attribute = "µãÐÄ";

	public Snack(String name, int num, String icon, double price, String ID) {
		this.seticon(icon);
		this.setID(ID);
		this.setname(name);
		this.setnum(num);
		this.setprice(price);
	}
}
