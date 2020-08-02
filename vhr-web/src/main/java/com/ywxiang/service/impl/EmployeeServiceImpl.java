package com.ywxiang.service.impl;

import com.ywxiang.dao.EmployDao;
import com.ywxiang.entity.Employee;
import com.ywxiang.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/1 下午12:19
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployDao employDao;

    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");

    @Override
    public List<Employee> getAllEmployees(Employee employee, Date[] beginDateScope) {
        return employDao.getAllEmployees(employee, beginDateScope);
    }

    @Override
    public Integer addEmps(List<Employee> list) {
        return employDao.addEmps(list);
    }

    @Override
    public Integer addEmp(Employee employee) {
        Date beginContract = employee.getBeginContract();
        Date endContract = employee.getEndContract();
        double month = (Double.parseDouble(yearFormat.format(endContract))
                - Double.parseDouble(yearFormat.format(beginContract))) * 12
                + (Double.parseDouble(monthFormat.format(endContract))
                - Double.parseDouble(monthFormat.format(beginContract)));
        employee.setContractTerm(Double.parseDouble(decimalFormat.format(month / 12)));
        int result = employDao.insertSelective(employee);
        return result;
    }
}
