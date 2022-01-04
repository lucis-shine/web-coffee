package dao.web;

import VO.web.CoffeeDetailVO;
import VO.web.CoffeeVO;

import java.util.List;

public interface ICoffeeDao {
    //获得所有咖啡信息
    List<CoffeeVO> selectCoffeeList();
    //按照类型查询商品列表
    List<CoffeeVO> selectCoffeeListByType(int type);
    //按照id查询商品信息
    CoffeeDetailVO selectCoffeeDetailById(int int_id);
}
