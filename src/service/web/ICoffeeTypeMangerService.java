package service.web;

import VO.web.CoffeeTypeVO;

import java.util.List;

//咖啡类型业务接口
public interface ICoffeeTypeMangerService {
    //查询咖啡类型集合
    List<CoffeeTypeVO> getCoffeeTypeList();
}
