package com.ywxiang.dao;

import com.ywxiang.entity.JobLevel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/2 上午11:22
 */
@Repository
public interface JobLevelDao {
    /**
     * 获取所有职称
     * @return
     */
    List<JobLevel> getAllJobLevels();
}
