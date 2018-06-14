package com.ttms.service;

import com.ttms.dao.SeatDao;
import com.ttms.dao.TicketDao;
import com.ttms.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Autowired
    private TicketDao ticketDao;

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

    @Override
    public String getticketstatus(String studio_id, String schedId) {
        List<Seat> seats = seatDao.getSeatsOfStudio(studio_id);
        String s = "";
        for (Seat seat : seats) {
            if (seat.getSeatStatus() == 0 || seat.getSeatStatus() == -1) {
                s += "-1,";
            } else if (seat.getSeatStatus() == 1) {
                Integer state = ticketDao.selectOne(seat.getId(), schedId);
                if (state == 0) {
                    s += "0,";
                } else if (state == 9 || state == 1) {
                    s += "1,";
                } else
                    s = "false";
            } else {
                s = "false";
            }
        }
        return s;
    }

    @Override
    public State saveticketstatus(String studio_id, String schedId, String saveStatus, String pay, String ticketPrice, String change) {
        List<Seat> seats = seatDao.getSeatsOfStudio(studio_id);
        List<Integer> list = new ArrayList<>();
        String[] split = saveStatus.split(",");
        for (int i = 0; i < split.length; i++) {
            list.add(seats.get(Integer.parseInt(split[i]) - 1).getId());
        }
        List<Ticket> tickets = ticketDao.selectTwo(schedId, list);
        for (Ticket ticket : tickets) {
            if (ticket.getTicketStatus() == 1 || ticket.getTicketStatus() == 9) {
                return new State(false, "该位置已被购买");
            } else {
                ticket.setTicketStatus((short) 9);
                ticketDao.updateStatus(ticket);
                return new State(true, "ok");
            }
        }

        return new State(false, "fail");
    }
}
