package com.ttms.dao;

import com.ttms.pojo.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/11
 */
public interface EmpDao {
    List<Employee> getList();

    List<Employee> getListByEmployee(Employee emp);

    int getEmployeeTotalCount();

    List<Employee> getEmployeesByPage(@Param("L") int L, @Param("pageSize") int pageSize);

    int getByConditionCount(Employee emp);

    void addEmployee(Employee emp) throws Exception;

    void updateEmployee(Employee emp) throws Exception;

    void deleteEmployee(String uuid);

    Employee getOneEmployee(Long uuid);

}
