package VO.web;

import POJO.OrdersPOJO;

public class OrdersVO extends OrdersPOJO {
    private String addressName;
    private String phone;
    private String linkman;
	public OrdersVO() {
	}
	public OrdersVO(Integer id, Integer addressid, String status, Integer userid) {
		super(id, addressid, status, userid);
	}
	public OrdersVO(Integer id, Integer addressid, String status, Integer userid, String addressName, String phone,
			String linkman) {
		super(id, addressid, status, userid);
		this.addressName = addressName;
		this.phone = phone;
		this.linkman = linkman;
	}
	public String getAddressName() {
		return addressName;
	}
	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLinkman() {
		return linkman;
	}
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
}
