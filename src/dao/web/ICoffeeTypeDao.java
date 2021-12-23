package dao.web;

import VO.web.CoffeeTypeVO;

import java.util.List;

//咖啡类型操作接口
public interface ICoffeeTypeDao {
    //查看咖啡类型集合
    List<CoffeeTypeVO> selectCoffeeTypeList();
}
