package service.web;

import VO.web.CoffeeNewsVO;
import dao.web.CoffeeNewsDao;
import dao.web.ICoffeeNewsDao;

import java.util.List;

public class CoffeeNewsManagerService implements ICoffeeNewsManagerService {
    ICoffeeNewsDao coffeeNewsDao = new CoffeeNewsDao();
	@Override
	public List<CoffeeNewsVO> getCoffeeNewsList() {
		return coffeeNewsDao.selectCoffeeNewsList();
	}
	@Override
	public CoffeeNewsVO getCoffeeNewsById(String id) {
		int int_id = Integer.parseInt(id);
		return coffeeNewsDao.selectCoffeeNewsById(int_id);
	}

}
