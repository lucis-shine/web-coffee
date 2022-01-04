package service.web;

import VO.web.CoffeeDetailVO;
import VO.web.CoffeeVO;

import java.util.List;

//咖啡信息业务接口
public interface ICoffeeMangerService {
    //查询咖啡所有类型
    List<CoffeeVO> getCoffeeList();
    //按照类型查询商品列表
    List<CoffeeVO> getCoffeeListByType(String typeId);
    //根据id查商品详细信息
    CoffeeDetailVO getCoffeeDetailById(String id);
}
