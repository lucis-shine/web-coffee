package dao.web;

import POJO.CollectsPOJO;
import VO.web.CollectsVO;
import utils.DataSourceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CollectsDao implements ICollectsDao {

	@Override
	public boolean insert(CollectsPOJO collectsPOJO) {
		Connection connection = DataSourceUtil.getConnection();
		PreparedStatement ps = null;
		try {
			String sql="insert into collects(coffeeid,userid) values (?,?)";
			ps = connection.prepareStatement(sql);
		 	ps.setInt(1, collectsPOJO.getCoffeeid());
		 	ps.setInt(2, collectsPOJO.getUserid());
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
	public boolean isCollectsCoffee(CollectsPOJO collectsPOJO) {
		Connection connection = DataSourceUtil.getConnection();
		PreparedStatement ps = null;
		try {
			String sql="select * from collects where coffeeid=? and userid=?";
			ps = connection.prepareStatement(sql);
		 	ps.setInt(1, collectsPOJO.getCoffeeid());
		 	ps.setInt(2, collectsPOJO.getUserid());
		 	ResultSet set = ps.executeQuery();
		 	if(set.next()) {
		 		return true;
		 	}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteCollects(CollectsPOJO collectsPOJO) {
		Connection connection = DataSourceUtil.getConnection();
		PreparedStatement ps = null;
		try {
			String sql="delete from collects where coffeeid=? and userid=?";
			ps = connection.prepareStatement(sql);
		 	ps.setInt(1, collectsPOJO.getCoffeeid());
		 	ps.setInt(2, collectsPOJO.getUserid());
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
	public List<CollectsVO> selectCollectsList(int userid) {
		List<CollectsVO> collectsList = new ArrayList<CollectsVO>();
		Connection connection = DataSourceUtil.getConnection();
		PreparedStatement ps = null;
		try {
			String sql="select collects.id,coffeeid,userid,picture,coffee.name coffeeName "
					+ " from collects,coffee where collects.coffeeid=coffee.id and userid=?";
			ps = connection.prepareStatement(sql);
		 	ps.setInt(1, userid);
		 	ResultSet set = ps.executeQuery();
		 	while(set.next()) {
		 		CollectsVO vo = new CollectsVO(set.getInt("id"),set.getInt("coffeeid") ,
		 				set.getInt("userid"),set.getString("picture") ,set.getString("coffeeName") );
		 		collectsList.add(vo);
		 	}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return collectsList;
	}

	@Override
	public boolean deleteCollectsBycollectsId(int collectsId) {
		Connection connection = DataSourceUtil.getConnection();
		PreparedStatement ps = null;
		try {
			String sql="delete from collects where id=?";
			ps = connection.prepareStatement(sql);
		 	ps.setInt(1, collectsId);
		 	int row = ps.executeUpdate();
		 	if(row>0) {
		 		return true;
		 	}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
