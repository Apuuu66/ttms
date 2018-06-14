package com.ttms.service;

import com.ttms.pojo.Employee;
import com.ttms.pojo.PageBean;
import com.ttms.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/11
 */
public interface UserService {
    List<User> getList();

    List<User> getListByUser(User user);

    PageBean<User> getPagebean(int currentPage, int pageSize);

    int getByConditionCount(User user);

    void addUser(User user) throws Exception;

    void updateUser(User user) throws Exception;

    void deleteUser(String uuid) throws Exception;

    List<Employee> getUnregistered();

    Map<String, Object> getEmpByNP(String username, String password);
}
