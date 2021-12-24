package service.web;

import VO.web.CoffeeNewsVO;

import java.util.List;

//咖啡新闻业务接口
public interface ICoffeeNewsMangerService {

    List<CoffeeNewsVO> coffeeNewsList();
}
