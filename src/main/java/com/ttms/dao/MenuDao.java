package com.ttms.dao;

import com.ttms.pojo.Menu;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/11
 */
public interface MenuDao {
    Menu getMenusTree(Integer pid);

    Menu getMenuById(String id);


    List<Menu> getMenusByEmpuuid(Long uuid);
}
