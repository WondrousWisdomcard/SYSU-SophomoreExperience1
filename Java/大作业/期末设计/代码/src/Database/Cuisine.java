package Database;

abstract public class Cuisine {// µ•∂¿≤À∆∑œ‘ æ
	private String name;
	private int num;
	private String icon;
	private double price;
	private String ID;

	public void setname(String name) {
		this.name = name;
	}

	public String getname() {
		return this.name;
	}

	public void setnum(int num) {
		this.num = num;
	}

	public int getnum() {
		return this.num;
	}

	public void seticon(String icon) {
		this.icon = icon;
	}

	public String geticon() {
		return this.icon;
	}

	public void setprice(double price) {
		this.price = price;
	}

	public double getprice() {
		return this.price;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getID() {
		return this.ID;
	}
}
