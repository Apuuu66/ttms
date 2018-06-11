package com.ttms.mobile.web;

import com.ttms.mobile.service.PlayServiceMobile;
import com.ttms.pojo.Employee;
import com.ttms.pojo.Play;
import com.ttms.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/11
 */
@Controller
public class MobileController {
    @Autowired
    private PlayServiceMobile playServiceMobile;
    @RequestMapping("/userM/login")
    @ResponseBody
    public Employee login(@RequestBody User user) {
        System.out.println(user.toString());
        Employee emp = new Employee();
        emp.setId(1);
        emp.setEmpNo("113");
        emp.setEmpName("反射光栅干啥");
        return emp;
    }

    @RequestMapping("/playM/list")
    @ResponseBody
    public List<Play> getList() {
        return playServiceMobile.getAllPlays();
    }
}
