package controller.web;


import VO.web.CoffeeDetailVO;
import VO.web.CoffeeVO;
import VO.web.CommentsVO;
import VO.web.UserLoginVO;
import service.web.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/before/coffee")
public class CoffeeManagerController extends HttpServlet{
	ICoffeeMangerService coffeeManagerService=new CoffeeMangerService();
	ICommentsManagerService commentsManagerService = new CommentsManagerService();
	ICollectsManagerService collectsManagerService = new CollectsManagerService();
	String method = "";
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		method = request.getParameter("m");
		System.out.println("method:"+method);
		if("coffeeListByType".equals(method)) {
			getCoffeeListByType(request,response);
		}else if("detail".equals(method)) {
			getCoffeeDetailById(request,response);
		}
	}
	private void getCoffeeDetailById(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException {
		//获得id
		String id = request.getParameter("id");
		//咖啡信息
		CoffeeDetailVO coffeeDetailVO = coffeeManagerService.getCoffeeDetailById(id);
		//评论信息
		List<CommentsVO>  commentsList =commentsManagerService.getCommentsListByCid(id);
		//收藏信息  ajax提交
		//获得用户信息
		HttpSession session = request.getSession();
		Object obj_user = session.getAttribute("webUserLogin");
		boolean b = false;
		if(obj_user!=null) {
			UserLoginVO userLoginVO =(UserLoginVO) obj_user;
		    b = collectsManagerService.isCollectsCoffee(id,userLoginVO.getId());
		}

		//封装到request上
		request.setAttribute("coffeeDetail", coffeeDetailVO);
		request.setAttribute("commentsList", commentsList);
		request.setAttribute("collectsCoffee", b);//是否收藏
		request.getRequestDispatcher("/before/coffee/coffeeDetail.jsp").forward(request, response);
	}
	private void getCoffeeListByType(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String typeId = request.getParameter("typeId");
		System.out.println("typeId:"+typeId);
		List<CoffeeVO> coffeeList = coffeeManagerService.getCoffeeListByType(typeId);
		System.out.println(coffeeList);
		request.setAttribute("coffeeList", coffeeList);
		request.getRequestDispatcher("/before/coffee/coffeeListByType.jsp").forward(request, response);
	}
	
}
