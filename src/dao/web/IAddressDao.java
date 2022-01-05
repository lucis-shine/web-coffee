package dao.web;

import POJO.AddressPOJO;
import VO.web.AddressVO;

import java.util.List;

public interface IAddressDao {

	boolean insert(AddressPOJO addreePOJO);

	List<AddressVO> selectAddressList(int userid);

	boolean delete(int id);

	AddressVO selectAddressById(int id);

	boolean update(int id, AddressPOJO addreePOJO);

}
