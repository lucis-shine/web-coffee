package dao.web;

import VO.web.CoffeeNewsVO;
import VO.web.CoffeeVO;

import java.util.List;

public interface ICoffeeNewsDao {
    //获得咖啡的具体信息
    CoffeeNewsVO selectCoffeeNewsById(int int_id);
    //获得所有咖啡信息
    List<CoffeeNewsVO> selectCoffeeNewsList();

  
}
