package controller.web;

import VO.web.CoffeeNewsVO;
import service.web.CoffeeNewsManagerService;
import service.web.ICoffeeNewsManagerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/before/coffeeNews")
public class CoffeeNewsManagerController extends HttpServlet{
    ICoffeeNewsManagerService coffeeNewsManagerService = new CoffeeNewsManagerService();
	String method = "";
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		method = request.getParameter("m");
		System.out.println("方法："+method);
		if("list".equals(method)) {
			list(request,response);
		}else if("detail".equals(method)) {
			getCoffeeNewsById(request,response);
		}
	}
	//咖啡详细信息
	private void getCoffeeNewsById(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println("id:"+id);
		CoffeeNewsVO coffeeNewsVO = coffeeNewsManagerService.getCoffeeNewsById(id);
		System.out.println(coffeeNewsVO);
		//绑定到request上去
		request.setAttribute("coffeeNewsVO", coffeeNewsVO);
		request.getRequestDispatcher("/before/coffeeNews/detail.jsp").forward(request, response);
	}
	//咖啡标题信息
	private void list(HttpServletRequest request, HttpServletResponse response) 
			 throws ServletException, IOException {
		List<CoffeeNewsVO> coffeeNewsList = coffeeNewsManagerService.getCoffeeNewsList();
        //组装咖啡数据
		request.setAttribute("coffeeNewsList", coffeeNewsList);
		request.getRequestDispatcher("/before/coffeeNews/list.jsp").forward(request, response);
	}
	
}
