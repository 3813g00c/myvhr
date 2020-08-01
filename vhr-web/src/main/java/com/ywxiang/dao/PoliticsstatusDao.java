package com.ywxiang.dao;

import com.ywxiang.entity.Position;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/1 下午3:55
 */
@Repository
public interface PoliticsstatusDao {
    /**
     * 获取政治面貌
     * @return
     */
    List<Position> getAllPoliticsstatus();
}
