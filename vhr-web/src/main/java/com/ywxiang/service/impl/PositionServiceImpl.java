package com.ywxiang.service.impl;

import com.ywxiang.dao.PositionDao;
import com.ywxiang.entity.Position;
import com.ywxiang.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/1 下午2:05
 */
@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    PositionDao positionDao;

    @Override
    public List<Position> getAllPositions() {
        return positionDao.getAllPositions();
    }
}
