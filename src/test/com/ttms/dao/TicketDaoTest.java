package com.ttms.dao;

import com.ttms.pojo.Ticket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class TicketDaoTest {
    @Autowired
    private TicketDao ticketDao;

    @Test
    public void selectTwo() {
        List<Integer> list = new ArrayList<>();
        list.add(15);
        List<Ticket> tickets = ticketDao.selectTwo(String.valueOf(1), list);
        System.out.println(tickets);
    }
}