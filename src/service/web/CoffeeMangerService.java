package service.web;

import VO.web.CoffeeDetailVO;
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

    @Override
    public List<CoffeeVO> getCoffeeListByType(String typeId) {
        int type = Integer.parseInt(typeId);
        return coffeeDao.selectCoffeeListByType(type);
    }

    @Override
    public CoffeeDetailVO getCoffeeDetailById(String id) {
        int int_id = Integer.parseInt(id);
        return coffeeDao.selectCoffeeDetailById(int_id);
    }
}
