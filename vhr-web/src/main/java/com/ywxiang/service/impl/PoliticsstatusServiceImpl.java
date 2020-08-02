package com.ywxiang.service.impl;

import com.ywxiang.dao.PoliticsstatusDao;
import com.ywxiang.entity.Politicsstatus;
import com.ywxiang.service.PoliticsstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/2 上午11:42
 */
@Service
public class PoliticsstatusServiceImpl implements PoliticsstatusService {

    @Autowired
    PoliticsstatusDao politicsstatusDao;

    @Override
    public List<Politicsstatus> getAllPoliticsstatus() {
        return politicsstatusDao.getAllPoliticsstatus();
    }
}
