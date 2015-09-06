package com.wolflowhereu.spring3.common;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by jxdyf09 on 15-8-31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@ActiveProfiles("local")
public class RedisServiceTest {
    private static Logger logger = LoggerFactory.getLogger(RedisServiceTest.class);

    @Autowired
    private RedisService redisService;

    @Test
    public void testDel() throws Exception {
        redisService.del("");
    }


    @Test
    public void testSet() throws Exception {
        System.out.println(redisService.get("test_1"));
        redisService.set("test_1", 1, 3000);
        System.out.println(redisService.get("test_1"));
        System.out.println(redisService.getLiveTime("test_1"));
    }

    @Test
    public void testSet1() throws Exception {

    }

    @Test
    public void testGet() throws Exception {

    }

    @Test
    public void testGetLiveTime() throws Exception {

    }

    @Test
    public void testKeys() throws Exception {

    }

    @Test
    public void testExists() throws Exception {

    }

    @Test
    public void testFlushDB() throws Exception {

    }

    @Test
    public void testDbSize() throws Exception {
        logger.debug(""+redisService.dbSize());
    }

    @After
    public void testPing() throws Exception {
        while (true) {
            logger.debug(redisService.ping());
            Thread.sleep(500);
        }
    }
}