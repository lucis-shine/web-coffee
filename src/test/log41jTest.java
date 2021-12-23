package test;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

public class log41jTest {

    public static void main(String[] args) {
      InputStream is= log41jTest.class.getClassLoader().getResourceAsStream("log41j.properties");
      PropertyConfigurator.configure(is);
      Logger logger= LoggerFactory.getLogger(log41jTest.class);
      logger.trace("-------------------追踪-----------");
      logger.debug("-------------------输出-----------");
      logger.info("-------------------提示-----------");
      logger.warn("-------------------警告-----------");
      logger.error("-------------------错误-----------");
    }
}
