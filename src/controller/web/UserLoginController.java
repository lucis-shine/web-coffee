package controller.web;

import VO.web.UserLoginVO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.web.IUserMangerService;
import service.web.UserMangerService;

import java.io.IOException;

@WebServlet("user/login")
public class UserLoginController extends HttpServlet {
    IUserMangerService userMangerService=new UserMangerService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userMangerService.login("","");
    }
}
