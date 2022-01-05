package VO.web;

import POJO.OrderdetailPOJO;

public class OrderdetailVO extends OrderdetailPOJO {
	private String coffeeName;
	private String picture;
	private double price;
	public OrderdetailVO() {
	}
	public OrderdetailVO(Integer id, Integer ordersid, Integer coffeeid, Integer num) {
		super(id, ordersid, coffeeid, num);
	}
	public OrderdetailVO(Integer id, Integer ordersid, Integer coffeeid, Integer num, String coffeeName,
			String picture,double price) {
		super(id, ordersid, coffeeid, num);
		this.coffeeName = coffeeName;
		this.picture = picture;
		this.price = price;
	}
	public String getCoffeeName() {
		return coffeeName;
	}
	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
