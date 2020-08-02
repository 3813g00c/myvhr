package com.ywxiang.service;

import com.ywxiang.entity.Politicsstatus;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/2 上午11:41
 */
public interface PoliticsstatusService {
    /**
     * 获取政治面貌
     * @return
     */
    List<Politicsstatus> getAllPoliticsstatus();
}
