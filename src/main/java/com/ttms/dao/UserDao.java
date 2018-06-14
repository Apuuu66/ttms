package com.ttms.dao;

import com.ttms.pojo.Employee;
import com.ttms.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/6
 */

public interface UserDao {
    List<User> getList();

    List<User> getListByUser(User user);

    int getUserTotalCount();

    List<User> getUsersByPage(@Param("L") int L, @Param("pageSize") int pageSize);

    int getByConditionCount(User user);

    void addUser(Integer id) throws Exception;

    void updateUser(User user) throws Exception;

    void deleteUser(String uuid);

    List<Employee> getUnregistered();

    Employee getEmpByNo(String username);

    User getUserById(Integer id);
}
