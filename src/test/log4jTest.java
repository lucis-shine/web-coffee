package test;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

public class log4jTest {
    static Logger logger= LoggerFactory.getLogger(log4jTest.class);
    public static void main(String[] args) {
      logger.trace("-------------------追踪-----------");
      logger.debug("-------------------输出-----------");
      logger.info("-------------------提示-----------");
      logger.warn("-------------------警告-----------");
      logger.error("-------------------错误-----------");
    }
}
