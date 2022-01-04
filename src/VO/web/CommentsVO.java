package VO.web;

import POJO.CommentsPOJO;

public class CommentsVO extends CommentsPOJO {
    private String userRealName;
	public CommentsVO() {
		super();
	}
	public CommentsVO(Integer id, Integer userid, Integer coffeeid, String content, String addtime) {
		super(id, userid, coffeeid, content, addtime);
	}
	public CommentsVO(Integer id, Integer userid, Integer coffeeid, String content, String addtime,
			String userRealName) {
		super(id, userid, coffeeid, content, addtime);
		this.userRealName = userRealName;
	}
	public String getUserRealName() {
		return userRealName;
	}
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

}
