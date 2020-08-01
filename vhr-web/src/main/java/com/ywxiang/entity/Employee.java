package com.ywxiang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ywxiang
 * @date 2020/8/1 上午11:27
 */
@Data
public class Employee implements Serializable {
    private static final long serialVersionUID = -4821728798203750996L;

    private Integer id;

    private String name;

    private String gender;

    private Date birthday;

    private String idCard;

    private String wedlock;

    private Integer nationId;

    private String nativePlace;

    private Integer politicId;

    private String email;

    private String phone;

    private String address;

    private Integer departmentId;

    private Integer jobLevelId;

    private Integer posId;

    private String engageForm;

    private String tiptopDegree;

    private String specialty;

    private String school;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date beginDate;

    private String workState;

    private String workID;

    private Double contractTerm;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date conversionTime;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date notWorkDate;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date beginContract;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date endContract;

    private Integer workAge;
    /**
     * 国家
     */
    private Nation nation;
    /**
     * 政治面貌
     */
    private Politicsstatus politicsstatus;
    /**
     *  部门
     */
    private Department department;
    /**
     * 职称
     */
    private JobLevel jobLevel;
    /**
     * 职位
     */
    private Position position;
    /**
     * 工资
     */
    private Salary salary;
}
