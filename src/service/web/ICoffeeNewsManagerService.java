package service.web;

import VO.web.CoffeeNewsVO;

import java.util.List;


 //咖啡咨询业务

public interface ICoffeeNewsManagerService {
	List<CoffeeNewsVO> getCoffeeNewsList();
	CoffeeNewsVO getCoffeeNewsById(String id);
}
