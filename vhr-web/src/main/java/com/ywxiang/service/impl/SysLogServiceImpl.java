package com.ywxiang.service.impl;

import com.ywxiang.dao.SysLogDao;
import com.ywxiang.entity.LogEntity;
import com.ywxiang.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ywxiang
 * @date 2020/7/4 下午6:19
 */
@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogDao sysLogDao;

    @Override
    public void addLog(LogEntity logEntity) {
        sysLogDao.addlog(logEntity);
    }
}
