package com.ttms.dao;

import com.ttms.pojo.Employee;
import com.ttms.pojo.User;
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
public class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void getList() {
        List<User> list = userDao.getList();
        System.out.println(list);
    }

    @Test
    public void getListByUser() {
        User user = new User();
        user.setId(1);
        List<User> listByUser = userDao.getListByUser(user);
    }

    @Test
    public void getUserTotalCount() {
    }

    @Test
    public void getUsersByPage() {
        List<User> usersByPage = userDao.getUsersByPage(0, 10);
    }

    @Test
    public void getByConditionCount() {
        User user = new User();
        user.setId(1);
        int conditionCount = userDao.getByConditionCount(user);
    }

    @Test
    public void addUser() throws Exception {
        userDao.addUser(7);
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void deleteUser() {
        List<Employee> unregistered = userDao.getUnregistered();
        System.out.println(unregistered);
    }
}