package POJO;

public class OrdersPOJO {
	private Integer id;
	private Integer addressid;
	private String status;
	private Integer userid;
	public OrdersPOJO() {}
	public OrdersPOJO(Integer addressid, String status, Integer userid) {
		this.addressid = addressid;
		this.status = status;
		this.userid = userid;
	}
	public OrdersPOJO(Integer id, Integer addressid, String status, Integer userid) {
		super();
		this.id = id;
		this.addressid = addressid;
		this.status = status;
		this.userid = userid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAddressid() {
		return addressid;
	}
	public void setAddressid(Integer addressid) {
		this.addressid = addressid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
}
