package VO.web;

import POJO.CoffeeNewsPOJO;

public class CoffeeNewsVO extends CoffeeNewsPOJO {
    public CoffeeNewsVO() {
    }

    public CoffeeNewsVO(Integer id, String picture, String title, String content, String addtime, String isDelete) {
        super(id, picture, title, content, addtime, isDelete);
    }
}
