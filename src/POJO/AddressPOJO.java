package POJO;

public class AddressPOJO {
	private Integer id;
	private String addressname;	
	private String phone;
	private String linkman;
	private Integer userid;
	private String def;
	public AddressPOJO() {}
	public AddressPOJO(String addressname, String phone, String linkman, Integer userid, String def) {
		this.addressname = addressname;
		this.phone = phone;
		this.linkman = linkman;
		this.userid = userid;
		this.def = def;
	}
	public AddressPOJO(Integer id, String addressname, String phone, String linkman, Integer userid, String def) {
		this.id = id;
		this.addressname = addressname;
		this.phone = phone;
		this.linkman = linkman;
		this.userid = userid;
		this.def = def;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAddressname() {
		return addressname;
	}
	public void setAddressname(String addressname) {
		this.addressname = addressname;
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
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getDef() {
		return def;
	}
	public void setDef(String def) {
		this.def = def;
	}
	
}