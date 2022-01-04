package POJO;

public class CommentsPOJO {
	private Integer id;
	private Integer userid;
	private Integer coffeeid;
	private String content;
	private String addtime;
	public CommentsPOJO() {}
	public CommentsPOJO(Integer userid, Integer coffeeid, String content, String addtime) {
		this.userid = userid;
		this.coffeeid = coffeeid;
		this.content = content;
		this.addtime = addtime;
	}
	public CommentsPOJO(Integer id, Integer userid, Integer coffeeid, String content, String addtime) {
		this.id = id;
		this.userid = userid;
		this.coffeeid = coffeeid;
		this.content = content;
		this.addtime = addtime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getCoffeeid() {
		return coffeeid;
	}
	public void setCoffeeid(Integer coffeeid) {
		this.coffeeid = coffeeid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAddtime() {
		return addtime;
	}
	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}
	

}
