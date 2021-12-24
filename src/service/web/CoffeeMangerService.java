package service.web;

import VO.web.CoffeeVO;
import dao.web.CoffeeDao;
import dao.web.ICoffeeDao;

import java.util.List;

public class CoffeeMangerService implements ICoffeeMangerService{
    ICoffeeDao coffeeDao=new CoffeeDao();
    @Override
    public List<CoffeeVO> getCoffeeList() {
        return coffeeDao.selectCoffeeList();
    }
}
