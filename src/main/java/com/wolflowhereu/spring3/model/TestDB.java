package com.wolflowhereu.spring3.model;

import java.util.List;

/**
 * Created by jxdyf09 on 15-8-25.
 */
public class TestDB {
    private int id;
    private String name;
    private String sex;
    private TestDB testDB;
    private List<TestDB> testDBs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public TestDB getTestDB() {
        return testDB;
    }

    public void setTestDB(TestDB testDB) {
        this.testDB = testDB;
    }

    public List<TestDB> getTestDBs() {
        return testDBs;
    }

    public void setTestDBs(List<TestDB> testDBs) {
        this.testDBs = testDBs;
    }
}
