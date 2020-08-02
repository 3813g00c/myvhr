package com.ywxiang.service.impl;

import com.ywxiang.dao.DepartmentDao;
import com.ywxiang.entity.Department;
import com.ywxiang.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/2 上午11:35
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentDao departmentDao;

    @Override
    public List<Department> getAllDepartmentsWithOutChildren() {
        return departmentDao.getAllDepartmentsWithOutChildren();
    }
}
