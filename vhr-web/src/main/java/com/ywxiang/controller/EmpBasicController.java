package com.ywxiang.controller;

import com.github.pagehelper.PageHelper;
import com.ywxiang.common.utils.POIUtils;
import com.ywxiang.common.utils.RespPageBean;
import com.ywxiang.entity.Employee;
import com.ywxiang.entity.Position;
import com.ywxiang.service.EmployeeService;
import com.ywxiang.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
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

    @Autowired
    PositionService positionService;

    @GetMapping("/")
    public RespPageBean getEmployByPage(@RequestParam Integer page, @RequestParam Integer size,
                                    Employee employee, Date[] beginDateScope){
        System.out.println(employee);
        System.out.println(Arrays.toString(beginDateScope));
        PageHelper.startPage(page, size);
        List<Employee> employees = employeeService.getAllEmployees(employee, beginDateScope);
        RespPageBean respPage = new RespPageBean();
        respPage.setTotal((long) employees.size());
        respPage.setData(employees);
        return respPage;
    }

    @GetMapping("/positions")
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportData(){
        List<Employee> employees = employeeService.getAllEmployees(null, null);
        return POIUtils.employee2Excel(employees);
    }
}
