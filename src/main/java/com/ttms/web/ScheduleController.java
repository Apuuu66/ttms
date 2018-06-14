package com.ttms.web;

import com.ttms.pojo.PageBean;
import com.ttms.pojo.State;
import com.ttms.pojo.Schedule;
import com.ttms.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/14
 */
@Controller
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));//第二个参数是控制是否支持传入的值是空，这个值很关键，如果指定为false，那么如果前台没有传值的话就会报错
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public List list() {
        List<Schedule> list = scheduleService.getList();
        return list;
    }

    //条件查找
    @RequestMapping(value = "/tt")
    @ResponseBody
    public Map getByCondition(Schedule schedule) {
        System.out.println(schedule);
        List<Schedule> list = scheduleService.getListByCondition(schedule);
        Map map = new HashMap();
        map.put("rows", list);
        int total = scheduleService.getByConditionCount(schedule);
        map.put("total", total);
        return map;
    }

    @RequestMapping("/page")
    @ResponseBody
    public Map schedulePage(HttpServletRequest request) {
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int pageSize = Integer.parseInt(request.getParameter("rows"));
        HashMap<String, Object> map = new HashMap<>();
        PageBean<Schedule> pageBean = scheduleService.getPagebean(currentPage, pageSize);
        map.put("rows", pageBean.getList());
        map.put("total", pageBean.getTotalCount());
        return map;
    }

    @RequestMapping("/salePage")
    @ResponseBody
    public Map salePage(HttpServletRequest request) {
        String playId = request.getParameter("playId");
        HashMap<String, Object> map = new HashMap<>();
        List<Schedule> list = scheduleService.getSale(playId);
        map.put("rows", list);
        map.put("total", list.size());
        return map;
    }

    @RequestMapping("/add")
    @ResponseBody
    public State addSchedule(Schedule schedule) {
        try {
            scheduleService.addSchedule(schedule);
            return new State(true, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new State(false, "添加失败");
    }

    @RequestMapping("/update")
    @ResponseBody
    public State updateSchedule(Schedule schedule) {
        try {
            scheduleService.updateSchedule(schedule);
            return new State(true, "更新成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new State(false, "更新失败");
    }

    @RequestMapping("/delete")
    @ResponseBody
    public State deleteSchedule(String id) {
        try {
            scheduleService.deleteSchedule(id);
            return new State(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new State(false, "删除失败");
    }
}