package utils;

import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
@WebServlet("/log42jTest")
public class Log4jInit extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("----------初始化日志配置信息------------");
        super.init();
        String prefix = getServletContext().getRealPath("/");
        String file = getInitParameter("log4j-init-file");
        System.out.println("----------对参数进行处理------------");
        System.out.println(prefix+file);
        PropertyConfigurator.configure(prefix+file);

    }
}
