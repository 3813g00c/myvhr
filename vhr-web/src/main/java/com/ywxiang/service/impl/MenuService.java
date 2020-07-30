package com.ywxiang.service.impl;

import com.ywxiang.dao.MenuDao;
import com.ywxiang.entity.Hr;
import com.ywxiang.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/7/28 下午8:52
 */
@Service
public class MenuService {

    @Autowired
    MenuDao menuDao;

    public List<Menu> getAllMenusWithRole() {
        return menuDao.getAllMenusWithRole();
    }

    List<Menu> getMenusByHrId(Integer hrid) {
        return menuDao.getMenusByHrId(hrid);
    }

    public List<Menu> getMenusByHrId() {
        return getMenusByHrId(((Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }
}
