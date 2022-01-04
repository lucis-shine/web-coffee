package controller.web;

import VO.web.CollectsVO;
import VO.web.UserLoginVO;
import service.web.CollectsManagerService;
import service.web.ICollectsManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/filter/before/collects")
public class CollectsManagerController extends HttpServlet{
	ICollectsManagerService collectsManagerService = new CollectsManagerService();
	String method = "";
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		method = request.getParameter("m");
		System.out.println("method："+method);
		if("add".equals(method)) {
			addCollects(request,response);
		}else if("list".equals(method)) {
			queryCollects(request,response);
		}else if("addOrRemove".equals(method)) {
			addOrRemoveCollectsAjax(request,response);
		}else if("remove".equals(method)) {
			remove(request,response);
		}
	}
	private void remove(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String collectsid = request.getParameter("collectsid");
		System.out.println("collectsid："+collectsid);
		boolean b = collectsManagerService.removeBycollectsId(collectsid);
		if(b) {
			request.getRequestDispatcher("/filter/before/collects?m=list").forward(request, response);
		}
	}
	//红心控制 添加或者移除收藏
	private void addOrRemoveCollectsAjax(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String coffeeid = request.getParameter("coffeeid");
		System.out.println("coffeei:"+coffeeid);
		//获得咖啡收藏中信息  coffeeid   userid
		HttpSession session = request.getSession();
		Object obj_user = session.getAttribute("webUserLogin");
		if(obj_user!=null) {
			UserLoginVO userLoginVO =(UserLoginVO) obj_user;
			int userid = userLoginVO.getId();
			System.out.println("coffeeid="+coffeeid);
			System.out.println("userid="+userid);
			boolean c = collectsManagerService.isCollectsCoffee(coffeeid, userid);
			boolean b = false;
			String op = "";
			if(c==true) {//已收藏
				//移除
				b = collectsManagerService.removeCollects(coffeeid,userid);
				op = "remove";
			} else {//未收藏
				//添加
				b = collectsManagerService.addCollects(coffeeid,userid);
				op = "add";
			}
			//根据b的true  返回数据
  			if(b) {
				response.getWriter().write(op);
			}else {
				response.getWriter().write("false");
			}
		}
	}
	//查询收藏
	private void queryCollects(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// 组装收藏咖啡信息
		HttpSession session = request.getSession();
		Object obj_user = session.getAttribute("webUserLogin");
		if(obj_user!=null) {
			UserLoginVO userLoginVO =(UserLoginVO) obj_user;
			int userid = userLoginVO.getId();
			List<CollectsVO> collectsList= collectsManagerService.getCollectsList(userid);
			System.out.println("collectsList："+collectsList);
			request.setAttribute("collectsList", collectsList);
		}
		//查询成功跳转到收藏列表页
		request.getRequestDispatcher("/before/collects/list.jsp").forward(request, response);
	}
	//数据库收藏商品
	private void addCollects(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//咖啡id
		String coffeeid = request.getParameter("coffeeid");
		//用户id
		HttpSession session = request.getSession();
		Object obj_user = session.getAttribute("webUserLogin");
		if(obj_user!=null) {
			UserLoginVO userLoginVO =(UserLoginVO) obj_user;
			int userid = userLoginVO.getId();
			System.out.println("-----------咖啡收藏-----------");
			System.out.println("coffeeid："+coffeeid);
			System.out.println("userid："+userid);
			boolean b = collectsManagerService.addCollects(coffeeid,userid);
			if(b) {
				//查询成功跳转到收藏列表查询severlet
				request.getRequestDispatcher("/filter/before/collects?m=list").forward(request, response);
			}
		}
	}
}
