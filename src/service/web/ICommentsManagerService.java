package service.web;


import VO.web.CommentsVO;

import java.util.List;

public interface ICommentsManagerService {

	List<CommentsVO> getCommentsListByCid(String id);
 
	boolean addComments(String coffeeid, int userid,String content);

}
