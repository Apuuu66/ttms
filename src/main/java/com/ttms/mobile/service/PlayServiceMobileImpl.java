package com.ttms.mobile.service;

import com.ttms.mobile.dao.PlayDaoMobile;
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
public class PlayServiceMobileImpl implements PlayServiceMobile {
    @Autowired
    private PlayDaoMobile playDaoMobile;

    @Override
    public List<Play> getAllPlays() {
        return playDaoMobile.getAllPlays();
    }
}
