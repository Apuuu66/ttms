package com.ttms.dao;

import com.ttms.pojo.Play;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class PlayDaoTest {
    @Autowired
    private PlayDao playDao;

    @Test
    public void getList() {
        List<Play> list = playDao.getList();
    }

    @Test
    public void testPlayDao() {
        String s = "hello.jpg";
        System.out.println(s.substring(3));
        System.out.println(s.lastIndexOf("."));
        System.out.println(s.substring(s.lastIndexOf("."), 6));
        System.out.println(new Date().getTime());
    }

    @Test
    public void testPlayDaoTest() {
//        File file = new File("D:\\Project\\ttms\\src\\main\\webapp\\image\\temp");
////        file.mkdir();
//        System.out.println(file.exists());
//        String path = Class.class.getClass().getResource("/").getPath();
//        System.out.println(path);
        String property = System.getProperty("user.dir");
        System.out.println(property);
        String realPath = "\\src\\main\\webapp\\image\\movie";
        File file = new File(property + realPath);
        System.out.println(file.exists());
        if (!file.exists()) {
            file.mkdir();
        }
        System.out.println(property + realPath);
        System.out.println(file.exists());

        String realPath1 = property + "\\src\\main\\webapp\\image\\movie";

        System.out.println(realPath1);
    }
}