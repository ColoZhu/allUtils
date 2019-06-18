package com.utils.log;


import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 日志测试
 */

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Slf4j
public class LoggerTest {

   // private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);
   private final static Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    /**
     * 一、传统方式实现日志
     */
    @Test
    public void test1() {
        logger.debug("debug message");
        logger.warn("warn message");
        logger.info("info message");
        logger.error("error message");
        logger.trace("trace message");
    }

}
