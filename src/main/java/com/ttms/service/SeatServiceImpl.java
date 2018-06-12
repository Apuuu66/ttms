package com.ttms.service;

import com.ttms.dao.SeatDao;
import com.ttms.pojo.PageBean;
import com.ttms.pojo.Seat;
import com.ttms.pojo.Studio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/12
 */
@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    private SeatDao seatDao;

    @Override
    public List<Seat> getList() {
        return seatDao.getList();
    }

    @Override
    public List<Seat> getListByCondition(Seat seat) {
        if (seat != null) {
            return seatDao.getListByCondition(seat);
        }
        return seatDao.getList();
    }

    @Override
    public PageBean<Seat> getPagebean(int currentPage, int pageSize) {
        int total = seatDao.getSeatTotalCount();
        int L = (currentPage - 1) * pageSize;
        List<Seat> list = seatDao.getSeatsByPage(L, pageSize);
        return new PageBean<>(pageSize, currentPage, total, list);
    }

    @Override
    public int getByConditionCount(Seat seat) {
        return seatDao.getByConditionCount(seat);
    }

    @Override
    public void addSeat(String studioId) throws Exception {
//        查询演出厅
        Studio studio = seatDao.getStudioById(studioId);
//        删除演出厅的所有座位
        seatDao.deleteStudioSeats(studio.getId());
        for (int i = 1; i <= studio.getStudioRowCount(); i++) {
            for (int j = 1; j <= studio.getStudioColCount(); j++) {
                seatDao.addSeat(studio.getId(), i, j);
            }
        }
    }

    @Override
    public void updateSeat(Seat seat) throws Exception {
        seatDao.updateSeat(seat);
    }

    @Override
    public void deleteSeat(String id) throws Exception {
        seatDao.deleteSeat(id);
    }

    @Override
    public List<Seat> getSeatsOfStudio(String id) {
        return seatDao.getSeatsOfStudio(id);
    }

    @Override
    public int getSeatsOfStudioCount(String id) {
        return seatDao.getSeatsOfStudioCount(id);
    }
}
