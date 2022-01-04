package controller.web;

import VO.web.UserLoginVO;
import service.web.CommentsManagerService;
import service.web.ICommentsManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/filter/before/comments")
public class CommentsManagerController extends HttpServlet{
	ICommentsManagerService commentsManagerService=new CommentsManagerService();
	String method = "";
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		method=request.getParameter("m");
		if("add".equals(method)) {
			addComments(request,response);
		}
	}
	private void addComments(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String coffeeid = request.getParameter("coffeeid");
		String content = request.getParameter("content");

		HttpSession session = request.getSession();
		Object obj_user = session.getAttribute("webUserLogin");
		if(obj_user!=null) {
			UserLoginVO userLoginVO =(UserLoginVO) obj_user;
			int userid = userLoginVO.getId();
			boolean b = commentsManagerService.addComments(coffeeid,userid,content);
			if(b) {
				request.getRequestDispatcher("/before/coffee?m=detail&&id="+coffeeid).forward(request, response);
			}
		}
	}
}
