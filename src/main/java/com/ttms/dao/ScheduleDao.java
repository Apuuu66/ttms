package com.ttms.dao;

import com.ttms.pojo.Schedule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/14
 */

public interface ScheduleDao {
    List<Schedule> getList();

    List<Schedule> getListByCondition(Schedule schedule);

    int getScheduleTotalCount();

    List<Schedule> getSchedulesByPage(@Param("L") int L, @Param("pageSize") int pageSize);

    int getByConditionCount(Schedule schedule);

    void addSchedule(Schedule schedule) throws Exception;

    void updateSchedule(Schedule schedule) throws Exception;

    void deleteSchedule(String id);

    List<Schedule> getSale(@Param("id") String playId);

}
