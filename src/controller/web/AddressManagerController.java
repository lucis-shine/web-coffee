package controller.web;

import VO.web.AddressVO;
import VO.web.UserLoginVO;
import service.web.AddressManagerService;
import service.web.IAddressManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/filter/before/address")
public class AddressManagerController extends HttpServlet {
	IAddressManagerService addressManagerService = new AddressManagerService();
	String method="";
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		method = request.getParameter("m");
		System.out.println("地址管理："+method);
		if("add".equals(method)) {
			add(request,response);
		}else if("list".equals(method)) {
			list(request,response);
		}else if("delete".equals(method)) {
			delete(request,response);
		}else if("get".equals(method)) {
			getAddressById(request,response);
		}else if("update".equals(method)) {
			update(request,response);
		}else if("myAddress".equals(method)) {
			myAddress(request,response);
		}
	}
	private void myAddress(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//查询数据库中是否存在商品信息  根据用户的id
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("webUserLogin");
		if(obj!=null) {
			UserLoginVO userLoginVO = (UserLoginVO)obj;
			int userid = userLoginVO.getId();
			List<AddressVO> addressList = addressManagerService.getAddressList(userid);
			request.setAttribute("addressList", addressList);
		}
		//response.sendRedirect("/eshop_web/before/address/list.jsp");//重定向
		request.getRequestDispatcher("/before/address/myShopAddress.jsp").forward(request, response);//转发
	}

	private void update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String addressname = request.getParameter("addressname");
		String phone = request.getParameter("phone");
		String linkman = request.getParameter("linkman");
		boolean b = addressManagerService.update(id,addressname,phone,linkman);
		if(b) {
			response.getWriter().write("true");
		}else {
			response.getWriter().write("false");
		}
	}

	private void getAddressById(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		AddressVO addressVO = addressManagerService.getAddressById(id);
		request.setAttribute("addressVO", addressVO);
		request.getRequestDispatcher("/before/address/update.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String id = request.getParameter("id");
		boolean b = addressManagerService.delete(id);
		if(b) {
			request.getRequestDispatcher("/filter/before/address?m=list").forward(request, response);//转发
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//查询数据库中是否存在商品信息  根据用户的id
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("webUserLogin");
		if(obj!=null) {
			UserLoginVO userLoginVO = (UserLoginVO)obj;
			int userid = userLoginVO.getId();
			List<AddressVO> addressList = addressManagerService.getAddressList(userid);
			request.setAttribute("addressList", addressList);
		}
		//response.sendRedirect("/eshop_web/before/address/list.jsp");//重定向
		request.getRequestDispatcher("/before/address/list.jsp").forward(request, response);//转发
	}
	
	private void add(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String addressname = request.getParameter("addressname");
		String phone = request.getParameter("phone");
		String linkman = request.getParameter("linkman");
		//从session中获得用户信息
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("webUserLogin");
		if(obj!=null) {
			UserLoginVO userLoginVO = (UserLoginVO)obj;
			int userid = userLoginVO.getId();
			boolean b = addressManagerService.addAddress(addressname,phone,linkman,userid);
			if(b) {
				response.getWriter().write("true");
			}else {
				response.getWriter().write("false");
			}
		}
	}
}
