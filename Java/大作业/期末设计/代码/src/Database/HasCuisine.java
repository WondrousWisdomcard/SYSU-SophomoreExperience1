package Database;

import java.io.Serializable;

public class HasCuisine extends Cuisine implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private int num;
	private double price;
	private double amountPrice;

	public HasCuisine(String name, int num, double price) {
		this.name = name;
		this.num = num;
		this.price = price;
		this.amountPrice = this.price * this.num;
	}

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

	public void setprice(double price) {
		this.price = price;
	}

	public double getprice() {
		return this.price;
	}

	public void setAmountPrice(double amountPrice) {
		this.amountPrice = amountPrice;
	}

	public double getAmountPrice() {
		return this.amountPrice;
	}
}
