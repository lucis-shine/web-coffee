package dao.web;

import java.util.List;

import POJO.CommentsPOJO;
import VO.web.CommentsVO;
;

public interface ICommentsDao {

	List<CommentsVO> selectCommentsListByCid(int coffeeId);

	boolean insert(CommentsPOJO collectsPOJO);

}
