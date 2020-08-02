package com.ywxiang.controller;

import com.github.pagehelper.PageHelper;
import com.ywxiang.common.RespBean;
import com.ywxiang.common.utils.POIUtils;
import com.ywxiang.common.utils.RespPageBean;
import com.ywxiang.entity.Employee;
import com.ywxiang.entity.Position;
import com.ywxiang.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

    @Autowired
    JoblevelService joblevelService;

    @Autowired
    PoliticsstatusService politicsstatusService;

    @Autowired
    NationService nationService;

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    public RespPageBean getEmployByPage(@RequestParam Integer page, @RequestParam Integer size,
                                    Employee employee, Date[] beginDateScope){
        PageHelper.startPage(page, size);
        List<Employee> employees = employeeService.getAllEmployees(employee, beginDateScope);
        RespPageBean respPage = new RespPageBean();
        respPage.setTotal((long) employees.size());
        respPage.setData(employees);
        return respPage;
    }

    @PostMapping("/")
    public RespBean addEmp(@RequestBody Employee employee) {
        if (employeeService.addEmp(employee) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
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

    @PostMapping("/import")
    public RespBean importData(MultipartFile file) throws IOException{
        List<Employee> list = POIUtils.excel2Employee(file, nationService.getAllNations(),
                politicsstatusService.getAllPoliticsstatus(), departmentService.getAllDepartmentsWithOutChildren(),
                positionService.getAllPositions(), joblevelService.getAllJobLevels());
        if (employeeService.addEmps(list) == list.size()){
            return RespBean.ok("上传成功");
        }
        return RespBean.error("上传失败");
    }

    @GetMapping("/maxWorkID")
    public RespBean maxWorkID() {
        RespBean respBean = RespBean.build().setStatus(200)
                .setObj(String.format("%08d", employeeService.maxWorkID() + 1));
        return respBean;
    }
}
