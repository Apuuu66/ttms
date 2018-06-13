package com.ttms.dao;

import com.ttms.pojo.DataDict;
import com.ttms.pojo.Play;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/11
 */
public interface PlayDao {
    List<Play> getList();

    List<Play> getListByCondition(Play play);

    int getPlayTotalCount();

    List<Play> getPlaysByPage(@Param("L") int L, @Param("pageSize") int pageSize);

    int getByConditionCount(Play play);

    void addPlay(Play play) throws Exception;

    void updatePlay(Play play) throws Exception;

    void deletePlay(String id);

    List<DataDict> getLangs();

    List<DataDict> getTypes();
}
