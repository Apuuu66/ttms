package com.ttms.dao;

import com.ttms.pojo.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class MenuDaoTest {
    @Autowired
    private MenuDao menuDao;

    @Test
    public void getMenusTree() {
        Menu menusTree = menuDao.getMenusTree(0);
        System.out.println(menusTree);
    }

    @Test
    public void getMenuById() {
        Menu menuById = menuDao.getMenuById("100");
        System.out.println(menuById);
    }
}