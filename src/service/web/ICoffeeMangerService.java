package service.web;

import VO.web.CoffeeVO;

import java.util.List;

//咖啡信息业务接口
public interface ICoffeeMangerService {

    List<CoffeeVO> getCoffeeList();
}
