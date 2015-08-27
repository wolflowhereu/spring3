package com.wolflowhereu.spring3.dao;

import com.wolflowhereu.spring3.model.TestDB;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by jxdyf09 on 15-8-25.
 */
public interface TestDBMapper {

    TestDB findById(@Param("id") int id);

    TestDB findAssociation(@Param("id") int id);

    List<TestDB> findByIds(List<Integer> ids);


    /**
     * 注解实现
     * @param id
     * @return
     */
    @Select("select * from test where id=#{id}")
    TestDB findByAnn(@Param("id") int id);

    List<TestDB> search(@Param("id") int id, @Param("sex") String sex, @Param("name") String name);
}
