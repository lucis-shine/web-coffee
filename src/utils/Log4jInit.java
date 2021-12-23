package utils;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import org.apache.log4j.PropertyConfigurator;

public class Log4jInit extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("----------初始化日志配置信息------------");
        String prefix = getServletContext().getRealPath("/");
        String file = getInitParameter("log4j-init-file");
        System.out.println("----------对参数进行处理------------");
        System.out.println(file+file);
        PropertyConfigurator.configure(prefix+file);
        super.init();
    }
}
