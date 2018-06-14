package com.ttms.dao;

import com.ttms.pojo.Ticket;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/14
 */
public interface TicketDao {
    void insert(Ticket ticket);

    Integer selectOne(@Param("seatId") Integer seatId, @Param("schedId") String schedId);

    List<Ticket> selectTwo(@Param("schedId") String schedId,@Param("list") List list);

    void updateStatus(Ticket ticket);
}
