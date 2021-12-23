package test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet("/log42jTest")
public class log42jTest extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger logger = LoggerFactory.getLogger(log42jTest.class);
        logger.trace("-------------------追踪-----------");
        logger.debug("-------------------输出-----------");
        logger.info("-------------------提示-----------");
        logger.warn("-------------------警告-----------");
        logger.error("-------------------错误-----------");
    }
}
