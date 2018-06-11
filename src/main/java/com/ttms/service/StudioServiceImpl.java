package com.ttms.service;

import com.ttms.dao.StudioDao;
import com.ttms.pojo.PageBean;
import com.ttms.pojo.Studio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/11
 */
@Service
public class StudioServiceImpl implements StudioService {
    @Autowired
    private StudioDao studioDao;

    @Override
    public List<Studio> getList() {
        return studioDao.getList();
    }

    @Override
    public List<Studio> getListByCondition(Studio studio) {
        if (studio != null) {
            return studioDao.getListByCondition(studio);
        }
        return studioDao.getList();
    }

    @Override
    public PageBean<Studio> getPagebean(int currentPage, int pageSize) {
        int total = studioDao.getStudioTotalCount();
        int L = (currentPage - 1) * pageSize;
        List<Studio> list = studioDao.getStudiosByPage(L, pageSize);
        return new PageBean<>(pageSize, currentPage, total, list);
    }

    @Override
    public int getByConditionCount(Studio studio) {
        return studioDao.getByConditionCount(studio);
    }

    @Override
    public void addStudio(Studio studio) throws Exception {
        studioDao.addStudio(studio);
    }

    @Override
    public void updateStudio(Studio studio) throws Exception {
        studioDao.updateStudio(studio);
    }

    @Override
    public void deleteStudio(String id) throws Exception {
        studioDao.deleteStudio(id);
    }
}
