package com.ttms.web;

import com.ttms.pojo.Employee;
import com.ttms.pojo.PageBean;
import com.ttms.pojo.State;
import com.ttms.pojo.User;
import com.ttms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/11
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public List list() {
        List<User> list = userService.getList();
        return list;
    }

    @RequestMapping(value = "/tt")
    @ResponseBody
    public Map getByCondition(User user) {
        System.out.println(user);
        List<User> list = userService.getListByUser(user);
        Map map = new HashMap();
        map.put("rows", list);
        int total = userService.getByConditionCount(user);
        map.put("total", total);
        return map;
    }

    @RequestMapping("/page")
    @ResponseBody
    public Map userPage(HttpServletRequest request) {
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int pageSize = Integer.parseInt(request.getParameter("rows"));
        HashMap<String, Object> map = new HashMap<>();
        PageBean<User> pageBean = userService.getPagebean(currentPage, pageSize);
        map.put("rows", pageBean.getList());
        map.put("total", pageBean.getTotalCount());
        return map;
    }

    @RequestMapping("/add")
    @ResponseBody
    public State addUser(User user) {
        try {
            userService.addUser(user);
            return new State(true, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new State(false, "添加失败");
    }

    @RequestMapping("/update")
    @ResponseBody
    public State updateUser(User user) {
        try {
            userService.updateUser(user);
            return new State(true, "更新成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new State(false, "更新失败");
    }

    @RequestMapping("/delete")
    @ResponseBody
    public State deleteUser(User user) {
        try {
            userService.deleteUser(String.valueOf(user.getId()));
            return new State(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new State(false, "删除失败");
    }

    @RequestMapping("/getUnregistered")
    @ResponseBody
    public List<Employee> getUnregistered() {
        return userService.getUnregistered();
    }
}
