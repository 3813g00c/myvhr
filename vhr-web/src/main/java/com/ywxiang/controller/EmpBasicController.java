package com.ywxiang.controller;

import com.github.pagehelper.PageHelper;
import com.ywxiang.common.utils.RespPageBean;
import com.ywxiang.entity.Employee;
import com.ywxiang.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/1 上午11:24
 */
@RestController
@RequestMapping("/employee/basic")
public class EmpBasicController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")
    public RespPageBean getEmployByPage(@RequestParam Integer page, @RequestParam Integer size,
                                    Employee employee, Date[] beginDateScope){
        PageHelper.startPage(page, size);
        List<Employee> employees = employeeService.getAllEmployees();
        RespPageBean respPage = new RespPageBean();
        respPage.setTotal(617L);
        respPage.setData(employees);
        return respPage;
    }
}
