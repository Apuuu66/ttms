package com.ttms.service;


import com.ttms.pojo.PageBean;
import com.ttms.pojo.Employee;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/11
 */
public interface EmpService {
    List<Employee> getList();

    List<Employee> getListByEmployee(Employee emp);

    PageBean<Employee> getPagebean(int currentPage, int pageSize);

    int getByConditionCount(Employee emp);

    void addEmployee(Employee emp) throws Exception;

    void updateEmployee(Employee emp) throws Exception;

    void deleteEmployee(String uuid) throws Exception;

}
