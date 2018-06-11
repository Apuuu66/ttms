package com.ttms.service;

import com.ttms.pojo.PageBean;
import com.ttms.pojo.Role;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/11
 */
public interface RoleService {
    List<Role> getList();

    List<Role> getListByRole(Role role);

    PageBean<Role> getPagebean(int currentPage, int pageSize);

    int getByConditionCount(Role role);

    void addRole(Role role) throws Exception;

    void updateRole(Role role) throws Exception;

    void deleteRole(String uuid) throws Exception;
}
