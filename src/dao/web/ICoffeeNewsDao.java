package dao.web;

import VO.web.CoffeeNewsVO;
import VO.web.CoffeeVO;

import java.util.List;

public interface ICoffeeNewsDao {
    List<CoffeeNewsVO> selectcoffeeNewsList();
    //获得所有咖啡信息
  
}
