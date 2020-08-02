package com.ywxiang.service;

import com.ywxiang.entity.Department;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/2 上午11:35
 */
public interface DepartmentService {
    List<Department> getAllDepartmentsWithOutChildren();
}
