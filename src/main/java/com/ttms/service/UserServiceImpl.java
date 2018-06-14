package com.ttms.service;


import com.ttms.dao.UserDao;
import com.ttms.pojo.Employee;
import com.ttms.pojo.PageBean;
import com.ttms.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/11
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getList() {
        return userDao.getList();
    }

    @Override
    public List<User> getListByUser(User user) {
        if (user != null) {
            return userDao.getListByUser(user);
        }
        return userDao.getList();
    }

    @Override
    public PageBean<User> getPagebean(int currentPage, int pageSize) {
        int total = userDao.getUserTotalCount();
        int L = (currentPage - 1) * pageSize;
        List<User> list = userDao.getUsersByPage(L, pageSize);
        return new PageBean<>(pageSize, currentPage, total, list);
    }

    @Override
    public int getByConditionCount(User user) {
        return userDao.getByConditionCount(user);
    }

    @Override
    public void addUser(User user) throws Exception {
        userDao.addUser(user.getId());
    }

    @Override
    public void updateUser(User user) throws Exception {
        userDao.updateUser(user);
    }


    @Override
    public void deleteUser(String uuid) throws Exception {
        userDao.deleteUser(uuid);
    }

    @Override
    public List<Employee> getUnregistered() {
        return userDao.getUnregistered();
    }

    @Override
    public Map<String, Object> getEmpByNP(String username, String password) {
        Employee emp = userDao.getEmpByNo(username);
        if (emp != null) {
            User user = userDao.getUserById(emp.getId());
            if (user != null && user.getEmpPass().equals(password)) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("emp", emp);
                map.put("user", user);
                return map;
            }
        }
        return null;
    }
}
