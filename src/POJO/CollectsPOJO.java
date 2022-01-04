package POJO;

public class CollectsPOJO {
	private int id;
	private int coffeeid;
	private int userid;
	public CollectsPOJO() {}
	public CollectsPOJO(int coffeeid, int userid) {
		this.coffeeid = coffeeid;
		this.userid = userid;
	}
	public CollectsPOJO(int id, int coffeeid, int userid) {
		super();
		this.id = id;
		this.coffeeid = coffeeid;
		this.userid = userid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCoffeeid() {
		return coffeeid;
	}
	public void setCoffeeid(int coffeeid) {
		this.coffeeid = coffeeid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
    
}
