package com.ywxiang.dao;

import com.ywxiang.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/2 上午11:32
 */
@Repository
public interface DepartmentDao {
    List<Department> getAllDepartmentsWithOutChildren();
}
