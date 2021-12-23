package service.web;

import VO.web.CoffeeTypeVO;
import dao.web.CoffeeTypeDao;
import dao.web.ICoffeeTypeDao;

import java.util.List;

public class CoffeeTypeMangerService implements ICoffeeTypeMangerService{
    ICoffeeTypeDao coffeeTypeDao=new CoffeeTypeDao();
    @Override
    public List<CoffeeTypeVO> getCoffeeTypeList() {
        return coffeeTypeDao.selectCoffeeTypeList();
    }
}
