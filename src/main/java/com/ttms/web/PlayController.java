package com.ttms.web;

import com.ttms.pojo.DataDict;
import com.ttms.pojo.PageBean;
import com.ttms.pojo.Play;
import com.ttms.pojo.State;
import com.ttms.service.PlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

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
        List<Play> list = playService.getListByCondition(play);
        Map map = new HashMap();
        map.put("rows", list);
        int total = playService.getByConditionCount(play);
        map.put("total", total);
        return map;
    }

    @RequestMapping("/page")
    @ResponseBody
    public Map playPage(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") int page,
                        @RequestParam(value = "rows", defaultValue = "12") int rows) {
        HashMap<String, Object> map = new HashMap<>();
        PageBean<Play> pageBean = playService.getPagebean(page, rows);
        map.put("rows", pageBean.getList());
        map.put("total", pageBean.getTotalCount());
        return map;
    }

    @RequestMapping("/onSalepage")
    @ResponseBody
    public Map onSalepage(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "rows", defaultValue = "12") int rows) {
        HashMap<String, Object> map = new HashMap<>();
        PageBean<Play> pageBean = playService.getPagebean(page, 100);
        List<Play> plays = pageBean.getList();
        Iterator<Play> iterator = plays.iterator();
        while (iterator.hasNext()) {
            Play next = iterator.next();
            if (next.getPlayStatus() == 0 || next.getPlayStatus() == -1)
                iterator.remove();
        }
        map.put("rows", plays);
        map.put("total", plays.size());
        return map;
    }

    @RequestMapping("/add")
    @ResponseBody
    public State addPlay(HttpServletRequest request, Play play) throws IOException {
        String name = play.getFile().getOriginalFilename();

        if (!play.getFile().isEmpty()) {
            String path = request.getServletContext().getRealPath("/image/movie");
            String filename = play.getFile().getOriginalFilename();
            String suffix = filename.substring(filename.lastIndexOf("."));
            String newFilename = new Date().getTime() + suffix;
            play.getFile().transferTo(new File(path + "/" + newFilename));
            try {
                play.setPlayImage("/image/movie/" + newFilename);
                playService.addPlay(play);
            } catch (Exception e) {
                e.printStackTrace();
            }
//            return "redirect:/play/page";
            return new State(true, "添加成功");
        } else
//            return "redirect:/play/page";
            return new State(false, "添加失败");
    }

    @RequestMapping("/update")
    @ResponseBody
    public State updatePlay() {
        try {
//            playService.updatePlay(play);
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

    @RequestMapping("/getLangs")
    @ResponseBody
    public List<DataDict> getLangs() {
        return playService.getLangs();
    }

    @RequestMapping("/getTypes")
    @ResponseBody
    public List<DataDict> getTypes() {
        return playService.getTypes();
    }
}
