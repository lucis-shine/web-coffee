package service.web;

import VO.web.AddressVO;

import java.util.List;

public interface IAddressManagerService {

	//增加地址
	boolean addAddress(String addressname, String phone, String linkman, int userid);

	 // 根据用户id获得地址信息列表
	List<AddressVO> getAddressList(int userid);

	 //删除地址信息
	boolean delete(String id);

	// 根据地址id获得地址信息返回到修改页
	AddressVO getAddressById(String id);

	// 修改地址信息
	boolean update(String id, String addressname, String phone, String linkman);

}
