package service.web;

import VO.web.OrderdetailVO;
import VO.web.OrdersVO;
import dao.web.IOrdersDao;
import dao.web.OrdersDao;

import java.util.List;

public class OrdersManagerService implements IOrdersManagerService{
	IOrdersDao ordersDao = new OrdersDao();
	@Override
	public List<OrdersVO> getOrdersListByUid(int userid) {
		return ordersDao.selectOrdersListByUid(userid);
	}
	@Override
	public OrdersVO getOrdersListById(String ordersId) {
		int id = Integer.parseInt(ordersId);
		return ordersDao.selectOrdersListById(id);
	}
	@Override
	public List<OrderdetailVO> getOrderItemListByOid(String ordersId) {
		int oid = Integer.parseInt(ordersId);
		return ordersDao.selectOrderItemListByOid(oid);
	}

}
