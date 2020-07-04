package com.ywxiang.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ywxiang
 * @date 2020/7/4 下午2:54
 */
@Data
public class LogEntity implements Serializable {

    private static final long serialVersionUID = -1543691262500708644L;

    private Long id;

    private String username;

    private String operation;

    private String method;

    private String params;

    private Long time;

    private String ip;

    private Date createDate;
}
