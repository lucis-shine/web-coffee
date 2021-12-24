package VO.web;

import POJO.CoffeePOJO;

public class CoffeeVO extends CoffeePOJO {

    public CoffeeVO() {
    }

    public CoffeeVO(Integer id, String picture, String name, Integer coffeetypeid, double price, int num, String netweight, String qualittydate, Integer tasteid, String brand, String storage, String detail) {
        super(id, picture, name, coffeetypeid, price, num, netweight, qualittydate, tasteid, brand, storage, detail);
    }


}
