package com.wolflowhereu.spring3.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jxdyf09 on 15-8-25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@ActiveProfiles("local")
public class PropertiesServiceTest {

    @Autowired
    private PropertiesService propertiesService;


    @Test
    public void testSayHello() throws Exception {
        propertiesService.sayHello();
    }

}