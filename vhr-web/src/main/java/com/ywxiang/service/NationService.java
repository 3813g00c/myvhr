package com.ywxiang.service;

import com.ywxiang.entity.Nation;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/2 上午11:38
 */
public interface NationService {
    /**
     * 获取所有国家
     * @return
     */
    List<Nation> getAllNations();
}
