package com.ttms.web;

import com.ttms.pojo.Employee;
import com.ttms.pojo.PageBean;
import com.ttms.pojo.State;
import com.ttms.service.EmpService;
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
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public List list() {
        List<Employee> list = empService.getList();
        return list;
    }

    @RequestMapping(value = "/tt")
    @ResponseBody
    public Map getByCondition(Employee emp) {
        System.out.println(emp);
        List<Employee> list = empService.getListByEmployee(emp);
        Map map = new HashMap();
        map.put("rows", list);
        int total = empService.getByConditionCount(emp);
        map.put("total", total);
        return map;
    }

    @RequestMapping("/page")
    @ResponseBody
    public Map empPage(HttpServletRequest request) {
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int pageSize = Integer.parseInt(request.getParameter("rows"));
        HashMap<String, Object> map = new HashMap<>();
        PageBean<Employee> pageBean = empService.getPagebean(currentPage, pageSize);
        map.put("rows", pageBean.getList());
        map.put("total", pageBean.getTotalCount());
        return map;
    }

    @RequestMapping("/add")
    @ResponseBody
    public State addEmployee(Employee emp) {
        try {
            empService.addEmployee(emp);
            return new State(true, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new State(false, "添加失败");
    }

    @RequestMapping("/update")
    @ResponseBody
    public State updateEmployee(Employee emp) {
        try {
            empService.updateEmployee(emp);
            return new State(true, "更新成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new State(false, "更新失败");
    }

    @RequestMapping("/delete")
    @ResponseBody
    public State deleteEmployee(String id) {
        try {
            empService.deleteEmployee(id);
            return new State(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new State(false, "删除失败");
    }

}
