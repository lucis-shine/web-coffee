package VO.web;

import POJO.CoffeePOJO;

public class CoffeeDetailVO extends CoffeePOJO {
    private String tasteName;
	public CoffeeDetailVO() {
		super();
	}
	public CoffeeDetailVO(Integer id, String picture, String name, Integer coffeetypeid, double price, int num,
			String netweight, String qualitydate, Integer tasteid, String brand, String storage, String detail) {
		super(id, picture, name, coffeetypeid, price, num, netweight, qualitydate, tasteid, brand, storage, detail);
	}

	public CoffeeDetailVO(Integer id, String picture, String name, Integer coffeetypeid, double price, int num,
			String netweight, String qualitydate, Integer tasteid, String brand, String storage, String detail,
			String tasteName) {
		super(id, picture, name, coffeetypeid, price, num, netweight, qualitydate, tasteid, brand, storage, detail);
		this.tasteName=tasteName;
	}
	public String getTasteName() {
		return tasteName;
	}
	public void setTasteName(String tasteName) {
		this.tasteName = tasteName;
	}
	
}
