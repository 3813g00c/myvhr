package com.ywxiang.dao;

import com.ywxiang.entity.Position;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/1 下午2:01
 */
@Repository
public interface PositionDao {
    /**
     * 获取所有的职位
     * @return
     */
    List<Position> getAllPositions();
}
