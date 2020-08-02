package com.ywxiang.service.impl;

import com.ywxiang.dao.NationDao;
import com.ywxiang.entity.Nation;
import com.ywxiang.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/2 上午11:39
 */
@Service
public class NationServiceImpl implements NationService {

    @Autowired
    NationDao nationDao;
    @Override
    public List<Nation> getAllNations() {
        return nationDao.getAllNations();
    }
}
