package com.ttms.dao;

import com.ttms.pojo.Studio;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/11
 */
public interface StudioDao {
    List<Studio> getList();

    List<Studio> getListByCondition(Studio studio);

    int getStudioTotalCount();

    List<Studio> getStudiosByPage(@Param("L") int L, @Param("pageSize") int pageSize);

    int getByConditionCount(Studio studio);

    void addStudio(Studio studio) throws Exception;

    void updateStudio(Studio studio) throws Exception;

    void deleteStudio(String id);
}
