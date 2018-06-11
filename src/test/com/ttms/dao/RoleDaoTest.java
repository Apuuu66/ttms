package com.ttms.dao;

import com.ttms.pojo.Role;
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
public class RoleDaoTest {
    @Autowired
    private RoleDao roleDao;

    @Test

    public void getList() {
        List<Role> list = roleDao.getList();
        System.out.println(list);
    }

    @Test
    public void getListByRole() {
        Role role = new Role();role.setUuid(1L);
        List<Role> listByRole = roleDao.getListByRole(role);

    }

    @Test
    public void getRoleTotalCount() {
        System.out.println(roleDao.getRoleTotalCount());
    }

    @Test
    public void getRolesByPage() {
    }

    @Test
    public void getByConditionCount() {
    }

    @Test
    public void addRole() {
    }

    @Test
    public void updateRole() {
    }

    @Test
    public void deleteRole() {
    }

    @Test
    public void getOneRole() {
    }
}