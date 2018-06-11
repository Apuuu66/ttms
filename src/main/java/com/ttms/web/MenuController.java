package com.ttms.web;


import com.ttms.pojo.Menu;
import com.ttms.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/6
 */
@Controller
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/getMenus")
    @ResponseBody
    public Menu getMenus() {
        return menuService.getMenusTree(0);
    }

    @RequestMapping("/getUserMenus")
    @ResponseBody
    public Menu getUserMenusTree() {
        return menuService.getMenusByEmpuuid(1L);
//        return menuService.getMenusByEmpuuid(2L);
    }
}
