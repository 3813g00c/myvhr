package com.ywxiang.dao;

import com.ywxiang.entity.LogEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author ywxiang
 * @date 2020/7/4 下午5:55
 */
@Repository
public interface SysLogDao {

    /**
     * 添加日志
     *
     * @param logEntity
     */
    void addlog(@Param("logEntity") LogEntity logEntity);
}
