package com.ttms.service;

import com.alibaba.druid.filter.AutoLoad;
import com.ttms.dao.PlayDao;
import com.ttms.dao.ScheduleDao;
import com.ttms.dao.SeatDao;
import com.ttms.dao.TicketDao;
import com.ttms.pojo.PageBean;
import com.ttms.pojo.Schedule;
import com.ttms.pojo.Seat;
import com.ttms.pojo.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/14
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private SeatDao seatDao;
    @Autowired
    private ScheduleDao scheduleDao;
    @Autowired
    private TicketDao ticketDao;
    @Autowired
    private PlayDao playDao;

    @Override
    public List<Schedule> getList() {
        return scheduleDao.getList();
    }

    @Override
    public List<Schedule> getListByCondition(Schedule schedule) {
        if (schedule != null) {
            return scheduleDao.getListByCondition(schedule);
        }
        return scheduleDao.getList();
    }

    @Override
    public PageBean<Schedule> getPagebean(int currentPage, int pageSize) {
        int total = scheduleDao.getScheduleTotalCount();
        int L = (currentPage - 1) * pageSize;
        List<Schedule> list = scheduleDao.getSchedulesByPage(L, pageSize);
        return new PageBean<>(pageSize, currentPage, total, list);
    }

    @Override
    public int getByConditionCount(Schedule schedule) {
        return scheduleDao.getByConditionCount(schedule);
    }

    @Override
    public void addSchedule(Schedule schedule) throws Exception {
        scheduleDao.addSchedule(schedule);
        Integer studioId = schedule.getStudioId();
        playDao.updateState(schedule.getPlayId());
        //查演出厅
        List<Seat> seats = seatDao.getSeatsOfStudio(String.valueOf(studioId));
        for (Seat seat : seats) {
            if (seat.getSeatStatus() == 1) {
                Ticket ticket = new Ticket();
                ticket.setSchedId(schedule.getId());
                ticket.setSeatId(seat.getId());
                ticket.setTicketPrice(schedule.getSchedTicketPrice());
                ticketDao.insert(ticket);
            }
        }
    }

    @Override
    public void updateSchedule(Schedule schedule) throws Exception {
        scheduleDao.updateSchedule(schedule);
    }

    @Override
    public void deleteSchedule(String id) throws Exception {
        scheduleDao.deleteSchedule(id);
    }

    @Override
    public List<Schedule> getSale(String playId) {
        return scheduleDao.getSale(playId);
    }
}
