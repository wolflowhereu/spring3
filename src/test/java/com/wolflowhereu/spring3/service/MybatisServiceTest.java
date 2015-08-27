package com.wolflowhereu.spring3.service;

import com.wolflowhereu.spring3.model.TestDB;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by jxdyf09 on 15-8-25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
@ActiveProfiles("local")
public class MybatisServiceTest {


    @Autowired
    private MybatisService mybatisService;

    @Test
    public void testSelectById() throws Exception {
        TestDB db = mybatisService.selectById(1);
        System.out.println(db.getName());
    }

    @Test
    public void testSelectByIds() throws Exception {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        ids.add(4);
        List<TestDB> dbs = mybatisService.selectByIds(ids);
        System.out.println(dbs.size());
    }

    @Test
    public void testSearch() throws Exception {
        List<TestDB> dbs = mybatisService.search(1, "", "");
        System.out.println(dbs.size());
    }

    @Test
    public void testFindAssociation() throws Exception {
        TestDB db = mybatisService.findAssociation(1);
        System.out.println(db.getName());
    }
}