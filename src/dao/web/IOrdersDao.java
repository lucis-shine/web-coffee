package dao.web;

import VO.web.OrderdetailVO;
import VO.web.OrdersVO;

import java.util.List;

public interface IOrdersDao {

   //根据会员id获得订单信息
	List<OrdersVO> selectOrdersListByUid(int userid);

    //根据订单id查询订单信息
	OrdersVO selectOrdersListById(int id);

	//根据订单id获得详单信息  在orderdetail表中
	List<OrderdetailVO> selectOrderItemListByOid(int oid);

}
