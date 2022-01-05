package VO.web;

import POJO.CartPOJO;

public class CartItemVO extends CartPOJO {
	private String coffeeName;
	private String coffeePicture;
	private double coffeePrice;
	public CartItemVO() {}
	public CartItemVO(Integer id, Integer coffeeid, Integer userid, Integer num, String coffeeName,
			String coffeePicture, double coffeePrice) {
		super(id, coffeeid, userid, num);
		this.coffeeName = coffeeName;
		this.coffeePicture = coffeePicture;
		this.coffeePrice = coffeePrice;
	}
	public String getCoffeeName() {
		return coffeeName;
	}
	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}
	public String getCoffeePicture() {
		return coffeePicture;
	}
	public void setCoffeePicture(String coffeePicture) {
		this.coffeePicture = coffeePicture;
	}
	public double getCoffeePrice() {
		return coffeePrice;
	}
	public void setCoffeePrice(double coffeePrice) {
		this.coffeePrice = coffeePrice;
	}
	
}
