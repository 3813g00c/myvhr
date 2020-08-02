package com.ywxiang.service;

import com.ywxiang.entity.JobLevel;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/2 上午11:37
 */
public interface JoblevelService {
    /**
     * 获取所有职称
     * @return
     */
    List<JobLevel> getAllJobLevels();
}
