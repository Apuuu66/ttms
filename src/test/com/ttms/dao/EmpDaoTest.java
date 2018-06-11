package com.ttms.dao;

import com.ttms.pojo.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class EmpDaoTest {
    @Autowired
    private EmpDao empDao;

    @Test
    public void getList() {
        List<Employee> list = empDao.getList();
    }

    @Test
    public void getListByEmployee() {
        Employee employee = new Employee();
        employee.setEmpNo("1");
        employee.setEmpName("张三");
        List<Employee> listByEmployee = empDao.getListByEmployee(employee);
    }

    @Test
    public void getEmployeeTotalCount() {
        int employeeTotalCount = empDao.getEmployeeTotalCount();
    }

    @Test
    public void getEmployeesByPage() {
        List<Employee> employeesByPage = empDao.getEmployeesByPage(2, 2);
    }

    @Test
    public void getByConditionCount() {
        Employee employee = new Employee();
        employee.setEmpNo("1");
        employee.setEmpName("张三");
        int byConditionCount = empDao.getByConditionCount(employee);
    }

    @Test
    public void addEmployee() throws Exception {
        Employee emp = new Employee();
        emp.setEmpNo("12313131231231");

        empDao.addEmployee(emp);
    }

    @Test
    public void updateEmployee() throws Exception {
        Employee emp = new Employee();
        emp.setEmpNo("12313131231231");
        emp.setEmpName("goudan");
        emp.setId(23);
        empDao.updateEmployee(emp);
    }

    @Test
    public void deleteEmployee() {
        empDao.deleteEmployee("23");
    }

    @Test
    public void getOneEmployee() {
    }
}