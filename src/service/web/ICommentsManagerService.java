package service.web;


import VO.web.CommentsVO;

import java.util.List;

public interface ICommentsManagerService {
	//获得评论列表
	List<CommentsVO> getCommentsListByCid(String id);
	//增加评论
	boolean addComments(String coffeeid, int userid,String content);

}
