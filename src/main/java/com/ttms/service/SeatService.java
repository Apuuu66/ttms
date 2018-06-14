package com.ttms.service;

import com.ttms.pojo.PageBean;
import com.ttms.pojo.Seat;
import com.ttms.pojo.State;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/12
 */
public interface SeatService {
    List<Seat> getList();

    List<Seat> getListByCondition(Seat seat);

    PageBean<Seat> getPagebean(int currentPage, int pageSize);

    int getByConditionCount(Seat seat);

    void addSeat(String id) throws Exception;

    void updateSeat(Seat seat) throws Exception;

    void deleteSeat(String id) throws Exception;

    List<Seat> getSeatsOfStudio(String id);

    int getSeatsOfStudioCount(String id);

    String getticketstatus(String studio_id, String schedId);

    State saveticketstatus(String studio_id, String schedId, String saveStatus, String pay, String ticketPrice, String change);

}
