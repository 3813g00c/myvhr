package com.ywxiang.controller;

import com.ywxiang.entity.LogEntity;
import com.ywxiang.service.SysLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ywxiang
 * @date 2020/7/4 下午7:11
 */
@Api("日志接口")
@RestController
@RequestMapping("/testswagger")
public class SwaggerTestController {

    @Autowired
    private SysLogService logService;

    @ApiOperation(value = "添加日志", notes = "添加日志信息")
    @PostMapping("/addlog")
    public String addLog(@RequestBody LogEntity logEntity){
        logService.addLog(logEntity);
        return "ok";
    }
}
