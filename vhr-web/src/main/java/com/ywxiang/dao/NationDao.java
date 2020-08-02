package com.ywxiang.dao;

import com.ywxiang.entity.Nation;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/2 上午11:29
 */
@Repository
public interface NationDao {
    /**
     * 获取所有国家
     * @return
     */
    List<Nation> getAllNations();
}
