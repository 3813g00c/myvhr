package com.ywxiang.service;

import com.ywxiang.entity.LogEntity;

/**
 * @author ywxiang
 * @date 2020/7/4 下午6:18
 */
public interface SysLogService {

    /**
     * 添加日志
     *
     * @param logEntity
     */
    void addLog(LogEntity logEntity);
}
