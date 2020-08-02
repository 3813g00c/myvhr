package com.ywxiang.service;

import com.ywxiang.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/1 下午12:18
 */
public interface EmployeeService {
    /**
     * 查询所有雇员信息
     * @return
     */
    List<Employee> getAllEmployees(Employee employee, Date[] beginDateScope);

    /**
     * 批量添加人事信息
     *
     * @param list
     * @return
     */
    Integer addEmps(@Param("list") List<Employee> list);

    /**
     * 添加雇员信息
     *
     * @param employee
     * @return
     */
    Integer addEmp(Employee employee);
}
