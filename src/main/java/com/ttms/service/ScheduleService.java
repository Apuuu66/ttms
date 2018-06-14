package com.ttms.service;

import com.ttms.pojo.PageBean;
import com.ttms.pojo.Schedule;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/14
 */
public interface ScheduleService {
    List<Schedule> getList();

    List<Schedule> getListByCondition(Schedule schedule);

    PageBean<Schedule> getPagebean(int currentPage, int pageSize);

    int getByConditionCount(Schedule schedule);

    void addSchedule(Schedule schedule) throws Exception;

    void updateSchedule(Schedule schedule) throws Exception;

    void deleteSchedule(String id) throws Exception;

    List<Schedule> getSale(String playId);
}
