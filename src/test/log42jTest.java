package test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
