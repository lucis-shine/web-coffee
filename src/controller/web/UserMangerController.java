package controller.web;

import VO.web.UserLoginVO;
import service.web.IUserMangerService;
import service.web.UserMangerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/before/user")
public class UserMangerController extends HttpServlet {
    IUserMangerService userMangerService=new UserMangerService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method="";//调用方法名称
        method=req.getParameter("m");
        System.out.println("方法："+method);
        if ("register".equals(method)){
            register(req,resp);
        }else if("login".equals(method)){
            login(req,resp);
        }
        else if("isRegister".equals(method)){
            isRegisterExistUsername(req,resp);
        }
    }
    //验证用户名是否相同
    private void isRegisterExistUsername(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        String username = request.getParameter("username");
        System.out.println("用户名"+username);
        boolean b  = userMangerService.isExistSameUsername(username);
        if(b) {
            response.getWriter().write("true");
        }else {
            response.getWriter().write("false");
        }
    }
    //用户注册方法
    private void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String name=req.getParameter("name");
        String sex=req.getParameter("sex");
        String email=req.getParameter("email");
        String phone=req.getParameter("phone");
        String birthday=req.getParameter("birthday");
        String picture=req.getParameter("picture");
        String address=req.getParameter("address");
        boolean b=userMangerService.register(username,password,name,sex,email,phone,birthday,picture,address);
        if (b){
            resp.getWriter().write("true");
        }
        else {
            resp.getWriter().write("false");
        }
    }
    //用户登录方法
    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        UserLoginVO userLoginVO=userMangerService.login(username,password);
        if (userLoginVO!=null){
            //绑定到session
            HttpSession session=req.getSession();
            session.setAttribute("webUserLogin",userLoginVO);
            resp.getWriter().write("true");
        }
        else {
            resp.getWriter().write("false");
        }
    }
}
