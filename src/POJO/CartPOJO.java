package POJO;

public class CartPOJO {
	private Integer id;
	private Integer coffeeid;
	private Integer userid;
	private Integer num;
	public CartPOJO() {}
	public CartPOJO(Integer coffeeid, Integer userid, Integer num) {
		this.coffeeid = coffeeid;
		this.userid = userid;
		this.num = num;
	}
	public CartPOJO(Integer id, Integer coffeeid, Integer userid, Integer num) {
		this.id = id;
		this.coffeeid = coffeeid;
		this.userid = userid;
		this.num = num;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCoffeeid() {
		return coffeeid;
	}
	public void setCoffeeid(Integer coffeeid) {
		this.coffeeid = coffeeid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	

}
