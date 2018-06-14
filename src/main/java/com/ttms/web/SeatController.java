package com.ttms.web;

import com.ttms.pojo.*;
import com.ttms.service.SeatService;
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
 * Date: 2018/6/12
 */
@Controller
@RequestMapping("/seat")
public class SeatController {
    @Autowired
    private SeatService seatService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public List list() {
        List<Seat> list = seatService.getList();
        return list;
    }

    //条件查找
//    @RequestMapping(value = "/tt")
//    @ResponseBody
//    public Map getByCondition(Seat seat) {
//        System.out.println(seat);
//        List<Seat> list = seatService.getListByCondition(seat);
//        Map map = new HashMap();
//        map.put("rows", list);
//        int total = seatService.getByConditionCount(seat);
//        map.put("total", total);
//        return map;
//    }

    @RequestMapping(value = "/tt")
    @ResponseBody
    public Map getByCondition(String id) {
        List<Seat> list = seatService.getSeatsOfStudio(id);
        Map map = new HashMap();
        map.put("rows", list);
        int total = seatService.getSeatsOfStudioCount(id);
        map.put("total", total);
        return map;
    }

    @RequestMapping("/page")
    @ResponseBody
    public Map seatPage(HttpServletRequest request) {
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int pageSize = Integer.parseInt(request.getParameter("rows"));
        HashMap<String, Object> map = new HashMap<>();
        PageBean<Seat> pageBean = seatService.getPagebean(currentPage, pageSize);
        map.put("rows", pageBean.getList());
        map.put("total", pageBean.getTotalCount());
        return map;
    }

    @RequestMapping("/add")
    @ResponseBody
    public State addSeat(String id) {
        try {
            seatService.addSeat(id);
            return new State(true, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new State(false, "添加失败");
    }

    @RequestMapping("/update")
    @ResponseBody
    public State updateSeat(Seat seat) {
        try {
            seatService.updateSeat(seat);
            return new State(true, "更新成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new State(false, "更新失败");
    }

    @RequestMapping("/delete")
    @ResponseBody
    public State deleteSeat(String id) {
        try {
            seatService.deleteSeat(id);
            return new State(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new State(false, "删除失败");
    }


    @RequestMapping("/getticketstatus")
    @ResponseBody
    public String getticketstatus(String studio_id, String schedId) {
        return seatService.getticketstatus(studio_id, schedId);
    }


    @RequestMapping("/saveticketstatus")
    @ResponseBody
    public State saveticketstatus(HttpServletRequest request, String studio_id, String schedId, String saveStatus, String pay, String ticketPrice, String change) {
        Employee user = (Employee) request.getSession().getAttribute("loginUser");
        return seatService.saveticketstatus(studio_id, schedId, saveStatus, pay, ticketPrice, change);
    }


}
