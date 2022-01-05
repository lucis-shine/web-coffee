package service.web;

import VO.web.OrderdetailVO;
import VO.web.OrdersVO;

import java.util.List;

public interface IOrdersManagerService {

   //根据会员id查询订单信息
	List<OrdersVO> getOrdersListByUid(int userid);

    // 根据订单id获得订单信息
	OrdersVO getOrdersListById(String ordersId);

	// 根据订单id查询 详单信息
	List<OrderdetailVO> getOrderItemListByOid(String ordersId);

}
