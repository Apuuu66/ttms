package com.ttms.dao;

import com.ttms.pojo.Studio;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SeatDaoTest {
    @Autowired
    private SeatDao seatDao;
    @Test
    public void addSeat() throws Exception {
        Studio studio = new Studio();
        studio.setId(3);
        studio.setStudioRowCount(0);
        studio.setStudioColCount(0);

        seatDao.deleteStudioSeats(studio.getId());
        for (int i = 1; i <= studio.getStudioRowCount(); i++) {
            for (int j = 1; j <= studio.getStudioColCount(); j++) {
                seatDao.addSeat(studio.getId(), i, j);
            }
        }
//        seatDao.addSeat(studio.getId(),studio.getStudioRowCount(),studio.getStudioColCount());
    }
}