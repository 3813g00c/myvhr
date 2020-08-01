package com.ywxiang.dao;

import com.ywxiang.entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/1 上午11:26
 */
@Repository
public interface EmployDao {

    /**
     * 查找所有雇员信息
     * @return
     */
    List<Employee> getAllEmployees(@Param("emp") Employee employee, @Param("beginDateScope") Date[] beginDateScope);

}
