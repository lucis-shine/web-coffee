package dao.web;

import POJO.AddressPOJO;
import VO.web.AddressVO;
import utils.DataSourceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AddressDao implements IAddressDao {

	@Override
	public boolean insert(AddressPOJO addreePOJO) {
		Connection connection = DataSourceUtil.getConnection();
		PreparedStatement ps = null;
		try {
			String sql="insert into address(addressname,phone,linkman,userid,def) "
		               +" values (?,?,?,?,?)";
			ps = connection.prepareStatement(sql);
		 	ps.setString(1, addreePOJO.getAddressname());
		 	ps.setString(2, addreePOJO.getPhone());
		 	ps.setString(3, addreePOJO.getLinkman());
		 	ps.setInt(4, addreePOJO.getUserid());
		 	ps.setString(5, addreePOJO.getDef());
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
	public List<AddressVO> selectAddressList(int userid) {
		List<AddressVO> addressList = new ArrayList<AddressVO>();
		Connection connection = DataSourceUtil.getConnection();
		PreparedStatement ps = null;
		try {
			String sql="select id,addressname,phone,linkman,userid,def "
		               +" from address where userid=?";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, userid);
		 	ResultSet set = ps.executeQuery();
		 	while(set.next()) {
		 		AddressVO vo = new AddressVO(set.getInt("id") ,set.getString("addressname") ,
		 				set.getString("phone"), set.getString("linkman"),
		 				set.getInt("userid") ,set.getString("def"));
		 		addressList.add(vo);
		 	}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return addressList;
	}

	@Override
	public boolean delete(int id) {
		Connection connection = DataSourceUtil.getConnection();
		PreparedStatement ps = null;
		try {
			String sql="delete from address where id=?";
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
	public AddressVO selectAddressById(int id) {
		AddressVO addressVO = null;
		Connection connection = DataSourceUtil.getConnection();
		PreparedStatement ps = null;
		try {
			String sql="select id,addressname,phone,linkman,userid,def "
		               +" from address where id=?";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
		 	ResultSet set = ps.executeQuery();
		 	if(set.next()) {
		 		addressVO = new AddressVO(set.getInt("id") ,set.getString("addressname") ,
		 				set.getString("phone"), set.getString("linkman"),
		 				set.getInt("userid") ,set.getString("def"));
		 	}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return addressVO;
	}

	@Override
	public boolean update(int id, AddressPOJO addreePOJO) {
		Connection connection = DataSourceUtil.getConnection();
		PreparedStatement ps = null;
		try {
			String sql="update address set addressname=?,phone=?,linkman=? "
		               +" where id=?";
			ps = connection.prepareStatement(sql);
		 	ps.setString(1, addreePOJO.getAddressname());
		 	ps.setString(2, addreePOJO.getPhone());
		 	ps.setString(3, addreePOJO.getLinkman());
		 	ps.setInt(4, id);
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
