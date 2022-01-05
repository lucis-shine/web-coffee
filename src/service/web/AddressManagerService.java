package service.web;

import POJO.AddressPOJO;
import VO.web.AddressVO;
import dao.web.AddressDao;
import dao.web.IAddressDao;

import java.util.List;

public class AddressManagerService implements IAddressManagerService{
	IAddressDao addressDao=new AddressDao();
	@Override
	public boolean addAddress(String addressname, String phone, String linkman, int userid) {
		AddressPOJO addressPOJO = new AddressPOJO(addressname, phone, linkman, userid, "否");
		return addressDao.insert(addressPOJO);
	}
	@Override
	public List<AddressVO> getAddressList(int userid) {
		return addressDao.selectAddressList(userid);
	}
	@Override
	public boolean delete(String id) {
		int int_id = Integer.parseInt(id);
		return addressDao.delete(int_id);
	}
	@Override
	public AddressVO getAddressById(String id) {
		int int_id = Integer.parseInt(id);
		return addressDao.selectAddressById(int_id);
	}
	@Override
	public boolean update(String id, String addressname, String phone, String linkman) {
		int int_id = Integer.parseInt(id);
		AddressPOJO addressPOJO = new AddressPOJO();
		addressPOJO.setAddressname(addressname);
		addressPOJO.setPhone(phone);
		addressPOJO.setLinkman(linkman);
		return addressDao.update(int_id, addressPOJO);
	}

}
