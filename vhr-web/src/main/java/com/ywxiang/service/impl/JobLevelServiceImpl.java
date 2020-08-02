package com.ywxiang.service.impl;

import com.ywxiang.dao.JobLevelDao;
import com.ywxiang.entity.JobLevel;
import com.ywxiang.service.JoblevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/2 上午11:37
 */
@Service
public class JobLevelServiceImpl implements JoblevelService {

    @Autowired
    JobLevelDao jobLevelDao;

    @Override
    public List<JobLevel> getAllJobLevels() {
        return jobLevelDao.getAllJobLevels();
    }
}
