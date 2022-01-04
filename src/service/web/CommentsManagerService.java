package service.web;

import POJO.CommentsPOJO;
import VO.web.CommentsVO;

import dao.web.CommentsDao;
import dao.web.ICommentsDao;
import utils.DateFormatUtil;

import java.util.Date;
import java.util.List;

public class CommentsManagerService implements ICommentsManagerService{
	ICommentsDao CommentsDao = new CommentsDao();
	@Override
	public List<CommentsVO> getCommentsListByCid(String id) {
		int int_id = Integer.parseInt(id);
		return CommentsDao.selectCommentsListByCid(int_id);
	}
	@Override
	public boolean addComments(String coffeeid, int userid,String content) {
		int cid = Integer.parseInt(coffeeid);
		String addtime = DateFormatUtil.parseDate(new Date(), "yyyy-MM-dd HH:mm:ss");//2020-02-08 00:00:00
		CommentsPOJO collectsPOJO = new CommentsPOJO(userid, cid, content, addtime);
		return CommentsDao.insert(collectsPOJO);
	}

}
