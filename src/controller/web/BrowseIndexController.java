package controller.web;

import VO.web.CoffeeTypeVO;
import VO.web.CoffeeVO;
import service.web.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//主页信息查看，控制
@WebServlet("/browseIndex")
public class BrowseIndexController extends HttpServlet {
    ICoffeeTypeMangerService coffeeTypeMangerService=new CoffeeTypeMangerService();
    ICoffeeMangerService coffeeMangerService=new CoffeeMangerService();
    String method="";//调用方法名称
    IUserMangerService userMangerService=new UserMangerService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        method=req.getParameter("m");
        if ("getCoffeeTypeList".equals(method)){
            getCoffeeTypeList(req,resp);
        }else if ("getCoffeeList".equals(method)){
            getCoffeeList(req,resp);
        }else if ("getCoffeeNewList".equals(method)){
            getCoffeeNewList(req,resp);
        }
    }
    //处理函数
    //获得咖啡类别
    public void getCoffeeTypeList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      List<CoffeeTypeVO> coffeeTypeList= coffeeTypeMangerService.getCoffeeTypeList();
      //绑定咖啡类型数据
        req.setAttribute("coffeeTypeList",coffeeTypeList);
      //跳转页面
        req.getRequestDispatcher("/before/index.jsp").forward(req,resp);
    }
    //获得咖啡基本信息
    public void getCoffeeList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CoffeeVO> coffeeList= coffeeMangerService.getCoffeeList();
        //绑定咖啡类型数据
        req.setAttribute("coffeeTypeList",coffeeList);
        //跳转页面
        req.getRequestDispatcher("/before/index.jsp").forward(req,resp);
    }
    //获得咖啡新闻信息
    public void getCoffeeNewList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
