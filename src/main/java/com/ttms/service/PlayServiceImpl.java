package com.ttms.service;


import com.ttms.dao.PlayDao;
import com.ttms.pojo.PageBean;
import com.ttms.pojo.Play;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/11
 */
@Service
public class PlayServiceImpl implements PlayService {
    @Autowired
    private PlayDao playDao;

    @Override
    public List<Play> getList() {
        return playDao.getList();
    }

    @Override
    public List<Play> getListByCondition(Play play) {
        if (play != null) {
            return playDao.getListByCondition(play);
        }
        return playDao.getList();
    }

    @Override
    public PageBean<Play> getPagebean(int currentPage, int pageSize) {
        int total = playDao.getPlayTotalCount();
        int L = (currentPage - 1) * pageSize;
        List<Play> list = playDao.getPlaysByPage(L, pageSize);
        return new PageBean<>(pageSize, currentPage, total, list);
    }

    @Override
    public int getByConditionCount(Play play) {
        return playDao.getByConditionCount(play);
    }

    @Override
    public void addPlay(Play play) throws Exception {
        playDao.addPlay(play);
    }

    @Override
    public void updatePlay(Play play) throws Exception {
        playDao.updatePlay(play);
    }

    @Override
    public void deletePlay(String id) throws Exception {
        playDao.deletePlay(id);
    }
}
