package controller.web;

import VO.web.UserLoginVO;
import service.web.IUserMangerService;
import service.web.UserMangerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/login")
public class UserLoginController extends HttpServlet {
    IUserMangerService userMangerService=new UserMangerService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userMangerService.login("","");
    }
}
