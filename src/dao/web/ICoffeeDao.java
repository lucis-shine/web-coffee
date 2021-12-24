package dao.web;

import VO.web.CoffeeVO;

import java.util.List;

public interface ICoffeeDao {
    //获得所有咖啡信息
    List<CoffeeVO> selectCoffeeList();
}
