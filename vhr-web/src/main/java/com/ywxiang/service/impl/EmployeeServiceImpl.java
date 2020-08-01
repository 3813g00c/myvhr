package com.ywxiang.service.impl;

import com.ywxiang.dao.EmployDao;
import com.ywxiang.entity.Employee;
import com.ywxiang.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/1 下午12:19
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployDao employDao;

    @Override
    public List<Employee> getAllEmployees() {
        return employDao.getAllEmployees();
    }
}
