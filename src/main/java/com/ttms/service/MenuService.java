package com.ttms.service;


import com.ttms.pojo.Menu;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/6
 */
public interface MenuService {
    Menu getMenusTree(Integer pid);

    Menu getMenusByEmpuuid(Long uuid);
}
