package com.ttms.service;

import com.ttms.pojo.PageBean;
import com.ttms.pojo.Play;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/11
 */
public interface PlayService {
    List<Play> getList();

    List<Play> getListByCondition(Play play);

    PageBean<Play> getPagebean(int currentPage, int pageSize);

    int getByConditionCount(Play play);

    void addPlay(Play play) throws Exception;

    void updatePlay(Play play) throws Exception;

    void deletePlay(String id) throws Exception;
}
