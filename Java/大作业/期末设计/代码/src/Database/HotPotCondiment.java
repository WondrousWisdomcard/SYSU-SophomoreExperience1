package Database;

public class HotPotCondiment extends Cuisine {
	private String attribute = "»ð¹øµ×ÁÏ";

	public HotPotCondiment(String name, int num, String icon, double price, String ID) {
		this.seticon(icon);
		this.setID(ID);
		this.setname(name);
		this.setnum(num);
		this.setprice(price);
	}
}
