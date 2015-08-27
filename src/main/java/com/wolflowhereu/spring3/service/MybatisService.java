package com.wolflowhereu.spring3.service;

import com.wolflowhereu.spring3.dao.TestDBMapper;
import com.wolflowhereu.spring3.model.TestDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by jxdyf09 on 15-8-25.
 */
@Service
@Transactional
public class MybatisService {
    @Autowired
    private TestDBMapper testDBMapper;

    public TestDB selectById(int id) {
        return testDBMapper.findByAnn(id);
    }

    public TestDB findAssociation(int id) {
        return testDBMapper.findAssociation(id);
    }

    public List<TestDB> selectByIds(List<Integer> ids) {
        return testDBMapper.findByIds(ids);
    }

    public List<TestDB> search(int id, String sex, String name) {
        return testDBMapper.search(id, sex, name);
    }
}
