package POJO;

public class OrderdetailPOJO {
	private Integer id;
	private Integer ordersid;
	private Integer coffeeid;
	private Integer num;
	public OrderdetailPOJO() {}
	public OrderdetailPOJO(Integer ordersid, Integer coffeeid, Integer num) {
		this.ordersid = ordersid;
		this.coffeeid = coffeeid;
		this.num = num;
	}
	public OrderdetailPOJO(Integer id, Integer ordersid, Integer coffeeid, Integer num) {
		super();
		this.id = id;
		this.ordersid = ordersid;
		this.coffeeid = coffeeid;
		this.num = num;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrdersid() {
		return ordersid;
	}
	public void setOrdersid(Integer ordersid) {
		this.ordersid = ordersid;
	}
	public Integer getCoffeeid() {
		return coffeeid;
	}
	public void setCoffeeid(Integer coffeeid) {
		this.coffeeid = coffeeid;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	


}
