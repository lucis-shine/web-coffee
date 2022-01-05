package dao.web;

import POJO.CartPOJO;
import VO.web.CartItemVO;
import VO.web.CartVO;
import utils.DataSourceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDao implements ICartDao {
	
	@Override
	public CartVO selectCartByCidAndUid(int cid, int userid) {
		CartVO cartVO = null;
		Connection connection = DataSourceUtil.getConnection();
		PreparedStatement ps = null;
		try {
			String sql="select id,coffeeid,userid,num from cart where coffeeid=? and userid=?";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, cid);
			ps.setInt(2, userid);
		 	ResultSet set = ps.executeQuery();
		 	if(set.next()) {
		 		cartVO = new CartVO(set.getInt("id") , 
		 				set.getInt("coffeeid"), set.getInt("userid"),set.getInt("num") );
		 	}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return cartVO;
	}

	@Override
	public boolean insert(CartPOJO cartPOJO) {
		Connection connection = DataSourceUtil.getConnection();
		PreparedStatement ps = null;
		try {
			String sql="insert into cart(coffeeid,userid,num) values (?,?,?)";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, cartPOJO.getCoffeeid());
			ps.setInt(2, cartPOJO.getUserid());
			ps.setInt(3, cartPOJO.getNum());
		 	int row = ps.executeUpdate();
		 	if(row>0) {
		 		return true;
		 	}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateNum(Integer id, int num) {
		Connection connection = DataSourceUtil.getConnection();
		PreparedStatement ps = null;
		try {
			String sql="update cart set num=num+? where id=?";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, num);
			ps.setInt(2, id);
		 	int row = ps.executeUpdate();
		 	if(row>0) {
		 		return true;
		 	}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<CartItemVO> selectCartItemListByUserid(int userid) {
		List<CartItemVO> cartItemList=new ArrayList<CartItemVO>();
		Connection connection = DataSourceUtil.getConnection();
		PreparedStatement ps = null;
		try {
			String sql="select cart.id,coffeeid,userid,cart.num,coffee.picture coffeePicture,"
					+ " coffee.name coffeeName,coffee.price coffeePrice from cart,coffee"
					+ " where userid=? and cart.coffeeid=coffee.id";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, userid);
		 	ResultSet set = ps.executeQuery();
		 	while(set.next()) {
		 		CartItemVO vo = new CartItemVO(set.getInt("id") ,set.getInt("coffeeid") ,
		 				set.getInt("userid"),set.getInt("num") ,set.getString("coffeeName") ,
		 				set.getString("coffeePicture"),set.getDouble("coffeePrice"));
		 		cartItemList.add(vo);
		 	}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return cartItemList;
	}

	@Override
	public boolean updateCartItemNumById(int id, int num) {
		Connection connection = DataSourceUtil.getConnection();
		PreparedStatement ps = null;
		try {
			String sql="update cart set num=? where id=?";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, num);
			ps.setInt(2, id);
		 	int row = ps.executeUpdate();
		 	if(row>0) {
		 		return true;
		 	}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteById(int id) {
		Connection connection = DataSourceUtil.getConnection();
		PreparedStatement ps = null;
		try {
			String sql="delete from cart where id=?";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
		 	int row = ps.executeUpdate();
		 	if(row>0) {
		 		return true;
		 	}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean submitCart(int userid,int addressId,double payMoney) {
		Connection connection = DataSourceUtil.getConnection();
		PreparedStatement ps = null;
		try {
			connection.setAutoCommit(false);
			//对地址表的操作
			String sql_address1 = "update address set def='否' where userid=?";//把用户的地址都改为不是默认地址
			String sql_address2 = "update address set def='是' where id=?";//设置一个默认地址
			ps = connection.prepareStatement(sql_address1);
			ps.setInt(1, userid);
			int row1 = ps.executeUpdate();
			ps = connection.prepareStatement(sql_address2);
			ps.setInt(1, addressId);
			int row2 = ps.executeUpdate();
			//订单表的操作
			String sql_orders1 = "insert into orders(addressid,status,userid) values (?,'已付款',?)";
			ps = connection.prepareStatement(sql_orders1);
			ps.setInt(1, addressId);
			ps.setInt(2, userid);
			int row3 = ps.executeUpdate();
			//获得orders表的新加入的id  自动增长的   自动增长值的下一个值
			String sql_orders2="SELECT auto_increment FROM information_schema.TABLES "+
			           " WHERE TABLE_SCHEMA='eshop_coffee' AND TABLE_NAME='orders'";
			ps = connection.prepareStatement(sql_orders2);
			ResultSet set = ps.executeQuery();
			int ordersId = -1;
			if(set.next()) {
				ordersId = set.getInt(1)-1;
			}
			//在orderdetail表中 插入操作   详单表
			String sql_orderdetail="insert into orderdetail(ordersid,coffeeid,num) "
			                      +" select "+ordersId+",coffeeid,num from cart where cart.userid=?";
			ps = connection.prepareStatement(sql_orderdetail);
			ps.setInt(1, userid);
			int row4 = ps.executeUpdate();
			//清空cart表中该用户的购物信息
			String sql_cart1="delete from cart where userid=?";
			ps = connection.prepareStatement(sql_cart1);
			ps.setInt(1, userid);
			int row5 = ps.executeUpdate();
			//更新账户余额
			String sql_user1="update user set money=money-? where id=?";
			ps = connection.prepareStatement(sql_user1);
			ps.setDouble(1, payMoney);
			ps.setInt(2, userid);
			int row6 = ps.executeUpdate();
			if(row1>0 && row2>0 && row3>0 && row4>0 && row5>0 && row6>0) {				
				connection.commit();
				return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}
