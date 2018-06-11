package com.ttms.service;


import com.ttms.dao.MenuDao;
import com.ttms.pojo.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/6
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;

    @Override
    public Menu getMenusTree(Integer pid) {
        return menuDao.getMenusTree(pid);
    }

    @Override
    public Menu getMenusByEmpuuid(Long uuid) {

        Menu root = menuDao.getMenusTree(0);
        //获取用户下所有菜单
        List<Menu> empMenus = menuDao.getMenusByEmpuuid(uuid);
        Menu menu = menuClone(root);
        //循环匹配模板
        Menu _m1 = null;
        Menu _m2 = null;
        //遍历一级菜单
        for (Menu m1 : root.getMenus()) {
            _m1 = menuClone(m1);
            //遍历二级级菜单
            for (Menu m2 : m1.getMenus()) {
                if (empMenus.contains(m2)) {
                    _m2 = menuClone(m2);
                    _m1.getMenus().add(_m2);
                }
            }
            //一级菜单中有二级菜单把一级菜单加到用户menu
            if (_m1.getMenus().size() > 0) {
                menu.getMenus().add(_m1);
            }
        }
        return menu;
    }

    private Menu menuClone(Menu src) {
        Menu menu = new Menu();
        menu.setIcon(src.getIcon());
        menu.setMenuname(src.getMenuname());
        menu.setMenuid(src.getMenuid());
        menu.setUrl(src.getUrl());
        menu.setMenus(new ArrayList<Menu>());
        return menu;
    }

}
