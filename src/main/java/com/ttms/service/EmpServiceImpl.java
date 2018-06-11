package com.ttms.service;

import com.ttms.dao.EmpDao;
import com.ttms.pojo.Employee;
import com.ttms.pojo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/11
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;


    @Override
    public List<Employee> getList() {
        return empDao.getList();
    }

    @Override
    public List<Employee> getListByEmployee(Employee emp) {
        if (emp != null) {
            return empDao.getListByEmployee(emp);
        }
        return empDao.getList();
    }

    @Override
    public PageBean<Employee> getPagebean(int currentPage, int pageSize) {
        int total = empDao.getEmployeeTotalCount();
        int L = (currentPage - 1) * pageSize;
        List<Employee> list = empDao.getEmployeesByPage(L, pageSize);
        return new PageBean<>(pageSize, currentPage, total, list);
    }

    @Override
    public int getByConditionCount(Employee emp) {
        return empDao.getByConditionCount(emp);
    }

    @Override
    public void addEmployee(Employee emp) throws Exception {
        empDao.addEmployee(emp);
    }

    @Override
    public void updateEmployee(Employee emp) throws Exception {
        empDao.updateEmployee(emp);
    }


    @Override
    public void deleteEmployee(String uuid) throws Exception {
        empDao.deleteEmployee(uuid);
    }

}
