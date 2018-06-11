package com.ttms.service;

import com.ttms.pojo.PageBean;
import com.ttms.pojo.Studio;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/11
 */
public interface StudioService {
    List<Studio> getList();

    List<Studio> getListByCondition(Studio studio);

    PageBean<Studio> getPagebean(int currentPage, int pageSize);

    int getByConditionCount(Studio studio);

    void addStudio(Studio studio) throws Exception;

    void updateStudio(Studio studio) throws Exception;

    void deleteStudio(String id) throws Exception;
}
