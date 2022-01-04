package dao.web;

import POJO.CommentsPOJO;
import VO.web.CommentsVO;
import utils.DataSourceUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CommentsDao implements ICommentsDao {

	@Override
	public List<CommentsVO> selectCommentsListByCid(int coffeeId) {
		List<CommentsVO> commentsList = new ArrayList<CommentsVO>();
		Connection connection = DataSourceUtil.getConnection();
		PreparedStatement ps = null;
		try {
			String sql="select c.id, userid, coffeeid, content, date_format(addtime,'%Y-%m-%d') addtime,"
					+ "u.name userRealName "
					+ "from comments c,user u where c.userid=u.id and coffeeid=?";
			ps = connection.prepareStatement(sql);
			ps.setInt(1, coffeeId);
		 	ResultSet set = ps.executeQuery();
		 	while(set.next()) {
		 		CommentsVO vo = new CommentsVO(set.getInt("id") ,set.getInt("userid") ,
		 				set.getInt("coffeeid"),set.getString("content") ,set.getString("addtime") ,
		 				set.getString("userRealName"));
		 		commentsList.add(vo);
		 	}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return commentsList;
	}

	@Override
	public boolean insert(CommentsPOJO commentsPOJO) {
		Connection connection = DataSourceUtil.getConnection();
		PreparedStatement ps = null;
		try {
			String sql="insert into comments(coffeeid,userid,content,addtime) values (?,?,?,?)";
			ps = connection.prepareStatement(sql);
		 	ps.setInt(1, commentsPOJO.getCoffeeid());
		 	ps.setInt(2, commentsPOJO.getUserid());
		 	ps.setString(3, commentsPOJO.getContent());
		 	ps.setString(4, commentsPOJO.getAddtime());
		 	int row = ps.executeUpdate();
		 	if(row>0) {
		 		return true;
		 	}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
