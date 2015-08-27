package com.wolflowhereu.spring3.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by jxdyf09 on 15-8-27.
 */
@Aspect
@Component
public class TestAspect {
    private static final Logger logger = LoggerFactory.getLogger(TestAspect.class);

    @Before(value = "@within(org.springframework.stereotype.Service)")
    public void log(){
        logger.info("someone call service method!!!");
    }

    @Before(value = "@annotation(com.wolflowhereu.spring3.annotation.SecurityValid)")
    public void security(){
        logger.info("you are safe!!!");
    }
}
