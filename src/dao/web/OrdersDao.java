package dao.web;

import VO.web.OrderdetailVO;
import VO.web.OrdersVO;
import utils.DataSourceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrdersDao implements IOrdersDao {
	@Override
	public List<OrdersVO> selectOrdersListByUid(int userid) {
		List<OrdersVO> orderList = new ArrayList<OrdersVO>();
		Connection connection = DataSourceUtil.getConnection();
		PreparedStatement ps = null;
		try {
			String sql="select o.*,a.addressName,a.phone,a.linkman from orders o,address a  "
		              +" where o.addressid=a.id and o.userid=?";
			ps = connection.prepareStatement(sql);
		 	ps.setInt(1, userid);
		 	ResultSet set = ps.executeQuery();
		 	while(set.next()) {
		 		OrdersVO vo = new OrdersVO(set.getInt("id") ,set.getInt("addressid"),
		 				set.getString("status"),set.getInt("userid") ,
		 				set.getString("addressName"),set.getString("phone") , set.getString("linkman"));
		 		orderList.add(vo);
		 	}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return orderList;
	}

	@Override
	public OrdersVO selectOrdersListById(int id) {
		OrdersVO vo = null;
		Connection connection = DataSourceUtil.getConnection();
		PreparedStatement ps = null;
		try {
			String sql="select o.*,a.addressName,a.phone,a.linkman from orders o,address a  "
		              +" where o.addressid=a.id and o.id=?";
			ps = connection.prepareStatement(sql);
		 	ps.setInt(1, id);
		 	ResultSet set = ps.executeQuery();
		 	if(set.next()) {
		 		vo = new OrdersVO(set.getInt("id") ,set.getInt("addressid"),
		 				set.getString("status"),set.getInt("userid") ,
		 				set.getString("addressName"),set.getString("phone") , set.getString("linkman"));
		 		
		 	}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public List<OrderdetailVO> selectOrderItemListByOid(int oid) {
		List<OrderdetailVO> orderdetailList = new ArrayList<OrderdetailVO>();
		Connection connection = DataSourceUtil.getConnection();
		PreparedStatement ps = null;
		try {
			String sql="select o.*,c.name coffeeName,c.picture,c.price from orderdetail o,coffee c"+
		               " where o.coffeeid=c.id and o.ordersid=?";
			ps = connection.prepareStatement(sql);
		 	ps.setInt(1, oid);
		 	ResultSet set = ps.executeQuery();
		 	while(set.next()) {
		 		OrderdetailVO vo = new OrderdetailVO(set.getInt("id") ,set.getInt("ordersid") ,
		 				set.getInt("coffeeid"),set.getInt("num") ,
		 				set.getString("coffeeName") ,set.getString("picture"),set.getDouble("price") );
		 		orderdetailList.add(vo);
		 	}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return orderdetailList;
	}

}
