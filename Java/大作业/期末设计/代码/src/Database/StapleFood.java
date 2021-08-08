package Database;

public class StapleFood extends Cuisine {
	private String attribute = "Ö÷Ê³";

	public StapleFood(String name, int num, String icon, double price, String ID) {
		this.seticon(icon);
		this.setID(ID);
		this.setname(name);
		this.setnum(num);
		this.setprice(price);
	}
}