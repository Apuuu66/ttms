package com.ttms.dao;

import com.ttms.pojo.Seat;
import com.ttms.pojo.Studio;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/12
 */
public interface SeatDao {
    List<Seat> getList();

    List<Seat> getListByCondition(Seat seat);

    int getSeatTotalCount();

    List<Seat> getSeatsByPage(@Param("L") int L, @Param("pageSize") int pageSize);

    int getByConditionCount(Seat seat);

    void addSeat(@Param("id") Integer id,@Param("row") Integer row,@Param("col") Integer col) throws Exception;

    void updateSeat(Seat seat) throws Exception;

    void deleteSeat(String id);

    List<Seat> getSeatsOfStudio(String id);

    int getSeatsOfStudioCount(String id);

    void deleteStudioSeats(@Param("id") Integer id);

    Studio getStudioById(String id);
}
