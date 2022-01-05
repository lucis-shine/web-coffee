package controller.web;

import VO.web.CartItemVO;
import VO.web.UserLoginVO;
import service.web.CartManagerService;
import service.web.ICartManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/filter/before/cart")
public class CartManagertController extends HttpServlet{
	ICartManagerService cartManagerService = new CartManagerService();
	String method="";
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		method = request.getParameter("m");
		System.out.println("购物车管理："+method);
		if("addCart".equals(method)) {
			addCart(request,response);
		}else if("list".equals(method)) {
			list(request,response);
		}else if("updateCartItemNum".equals(method)) {
			updateCartItemNum(request,response);
		}else if("remove".equals(method)) {
			removeCartItem(request,response);
		}else if("submitCart".equals(method)) {
			submitCart(request,response);
		}
	}
	private void submitCart(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String strAddressId = request.getParameter("addressId");
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("webUserLogin");
		if(obj!=null) {
			UserLoginVO userLoginVO = (UserLoginVO)obj;
			int userid = userLoginVO.getId();
			//查询购物车的列表
			List<CartItemVO> cartItemList = cartManagerService.getCartListByUserid(userid);
			//总价格
			double totalPrice = 0;
			for(CartItemVO vo:cartItemList) {
				totalPrice = totalPrice+vo.getCoffeePrice()*vo.getNum();
			}
			if(totalPrice>userLoginVO.getMoney()) {
				//余额不足
				response.getWriter().write("NotSufficient");
				return;
			}
			//开始进行订单创建
			boolean b = cartManagerService.submitCart(userid,strAddressId,totalPrice);
			if(b) {
				response.getWriter().write("true");
			}else {
				response.getWriter().write("false");
			}
		}
	}

	private void removeCartItem(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String cartId = request.getParameter("id");
		boolean b =cartManagerService.removeCartItem(cartId);
		if(b) {
			response.getWriter().write("true");
		}else {
			response.getWriter().write("false");
		}
	}

	private void updateCartItemNum(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String cartId = request.getParameter("id");
		String cartNum = request.getParameter("num");
		boolean b = cartManagerService.updateCartItemNumById(cartId,cartNum);
		if(b) {
			response.getWriter().write("true");
		}else {
			response.getWriter().write("false");
		}
	}

	private void list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("webUserLogin");
		if(obj!=null) {
			UserLoginVO userLoginVO = (UserLoginVO)obj;
			int userid = userLoginVO.getId();
			List<CartItemVO> cartItemList = cartManagerService.getCartListByUserid(userid);
			request.setAttribute("cartItemList", cartItemList);
			//总价格
			double totalPrice = 0;
			for(CartItemVO vo:cartItemList) {
				totalPrice = totalPrice+vo.getCoffeePrice()*vo.getNum();
			}
			request.setAttribute("totalPrice", totalPrice);
			request.getRequestDispatcher("/before/cart/list.jsp").forward(request, response);
		}
	}

	private void addCart(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String coffeeid = request.getParameter("coffeeid");
		String num = request.getParameter("num");
		System.out.println("coffeeid="+coffeeid);
		System.out.println("num="+num);
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("webUserLogin");
		if(obj!=null) {
			UserLoginVO userLoginVO = (UserLoginVO)obj;
			int userid = userLoginVO.getId();
			boolean b = cartManagerService.addOrUpdateCart(coffeeid,num,userid);
			if(b) {
				//跳转到购物车列表页
				request.getRequestDispatcher("/filter/before/cart?m=list").forward(request, response);
			}
		}
	}

}
