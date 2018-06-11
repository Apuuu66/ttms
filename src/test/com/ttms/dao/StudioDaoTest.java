package com.ttms.dao;

import com.ttms.pojo.Studio;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class StudioDaoTest {
    @Autowired
    private StudioDao studioDao;

    @Test
    public void getList() {
        List<Studio> list = studioDao.getList();
    }

    @Test
    public void getListByStudio() {
    }

    @Test
    public void getStudioTotalCount() {
    }

    @Test
    public void getStudiosByPage() {
    }

    @Test
    public void getByConditionCount() {
    }

    @Test
    public void addStudio() {
    }

    @Test
    public void updateStudio() {
    }

    @Test
    public void deleteStudio() {
    }
}