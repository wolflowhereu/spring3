package com.wolflowhereu.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by jxdyf09 on 15-8-26.
 */
public class LogbackTest {
    private static Logger logger = LoggerFactory.getLogger(LogbackTest.class);

    @Test
    public void logTest() throws InterruptedException {
        while (true) {
            Thread.sleep(500);
            logger.debug("测试debug~~~~~~~~~~~~");
            logger.info("测试info~~~~~~~~~~");
            logger.warn("测试warn~~~~~~~~~");
            logger.error("测试error~~~~~~~~~~~~~~");
        }
    }
}
