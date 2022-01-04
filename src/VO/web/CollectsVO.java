package VO.web;

import POJO.CollectsPOJO;


public class CollectsVO extends CollectsPOJO {
	private String picture;
	private String coffeeName;
	public CollectsVO() {}
	public CollectsVO(int id, int coffeeid, int userid, String picture, String coffeeName) {
		super(id, coffeeid, userid);
		this.picture = picture;
		this.coffeeName = coffeeName;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getCoffeeName() {
		return coffeeName;
	}
	public void setCoffeeName(String coffeeName) {
		this.coffeeName = coffeeName;
	}
}
