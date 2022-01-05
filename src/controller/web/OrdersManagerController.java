package controller.web;

import VO.web.OrderdetailVO;
import VO.web.OrdersVO;
import VO.web.UserLoginVO;
import service.web.IOrdersManagerService;
import service.web.OrdersManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/filter/before/orders")
public class OrdersManagerController extends HttpServlet{
    String method="";
    IOrdersManagerService ordersManagerService=new OrdersManagerService();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		method = request.getParameter("m");
		if("list".equals(method)) {
			list(request,response);
		}else if("get".equals(method)) {
			getOrdersItem(request,response);
		}
	}

	private void getOrdersItem(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String ordersId = request.getParameter("id");
		//订单信息
		OrdersVO ordersVO = ordersManagerService.getOrdersListById(ordersId);
		//详单列表
		List<OrderdetailVO> orderdetailList =  ordersManagerService.getOrderItemListByOid(ordersId);
		//封装到request对象上
		request.setAttribute("ordersVO", ordersVO);
		request.setAttribute("orderdetailList", orderdetailList);
		request.getRequestDispatcher("/before/orders/detail.jsp").forward(request, response);
	}

	private void list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("webUserLogin");
		if(obj!=null) {
			UserLoginVO userLoginVO = (UserLoginVO)obj;
			int userid = userLoginVO.getId();
			List<OrdersVO> ordersList = ordersManagerService.getOrdersListByUid(userid);
			request.setAttribute("ordersList", ordersList);
			request.getRequestDispatcher("/before/orders/list.jsp").forward(request, response);
		}
	}
}
