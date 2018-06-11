package com.ttms.mobile.dao;

import com.ttms.pojo.Play;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")

public class PlayDaoMobileTest {
    @Autowired
    private PlayDaoMobile playDaoMobile;

    @Test
    public void getAllPlays() {
        List<Play> allPlays = playDaoMobile.getAllPlays();
        System.out.println(allPlays);
    }
}