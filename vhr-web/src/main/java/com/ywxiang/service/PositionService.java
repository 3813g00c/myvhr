package com.ywxiang.service;

import com.ywxiang.entity.Position;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/1 下午2:05
 */
public interface PositionService {
    /**
     * 获取所有的职位
     * @return
     */
    List<Position> getAllPositions();
}
