package service.web;

import VO.web.CoffeeNewsVO;
import VO.web.CoffeeVO;
import dao.web.CoffeeDao;
import dao.web.CoffeeNewsDao;
import dao.web.ICoffeeDao;
import dao.web.ICoffeeNewsDao;

import java.util.List;

public class CoffeeNewsMangerService implements ICoffeeNewsMangerService {

    ICoffeeNewsDao coffeeNewsDao=new CoffeeNewsDao();
    @Override
    public List<CoffeeNewsVO> coffeeNewsList() {
        return coffeeNewsDao.selectCoffeeNewsList();
    }
}
