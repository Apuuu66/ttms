package com.ttms.web;

import com.ttms.pojo.PageBean;
import com.ttms.pojo.State;
import com.ttms.pojo.Play;
import com.ttms.service.PlayService;
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
@RequestMapping("/play")
public class PlayController {
    @Autowired
    private PlayService playService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public List list() {
        List<Play> list = playService.getList();
        return list;
    }

    //条件查找
    @RequestMapping(value = "/tt")
    @ResponseBody
    public Map getByCondition(Play play) {
        System.out.println(play);
        List<Play> list = playService.getListByCondition(play);
        Map map = new HashMap();
        map.put("rows", list);
        int total = playService.getByConditionCount(play);
        map.put("total", total);
        return map;
    }

    @RequestMapping("/page")
    @ResponseBody
    public Map playPage(HttpServletRequest request) {
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int pageSize = Integer.parseInt(request.getParameter("rows"));
        HashMap<String, Object> map = new HashMap<>();
        PageBean<Play> pageBean = playService.getPagebean(currentPage, pageSize);
        map.put("rows", pageBean.getList());
        map.put("total", pageBean.getTotalCount());
        return map;
    }

    @RequestMapping("/add")
    @ResponseBody
    public State addPlay(Play play) {
        try {
            playService.addPlay(play);
            return new State(true, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new State(false, "添加失败");
    }

    @RequestMapping("/update")
    @ResponseBody
    public State updatePlay(Play play) {
        try {
            playService.updatePlay(play);
            return new State(true, "更新成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new State(false, "更新失败");
    }

    @RequestMapping("/delete")
    @ResponseBody
    public State deletePlay(String id) {
        try {
            playService.deletePlay(id);
            return new State(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new State(false, "删除失败");
    }
}
