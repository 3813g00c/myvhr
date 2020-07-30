package com.ywxiang.controller;

import com.ywxiang.entity.Menu;
import com.ywxiang.service.impl.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/7/30 下午8:51
 */
@RestController
@RequestMapping("/system/config")
public class SystemController {
    @Autowired
    MenuService menuService;

    @GetMapping("/menu")
    public List<Menu> getMenusByHrId() {
        return menuService.getMenusByHrId();
    }
}
