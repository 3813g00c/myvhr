package com.ywxiang.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ywxiang
 * @date 2020/7/5 下午1:49
 */
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = -9004458739503040817L;

    private Integer id;

    private String name;

    private String nameZh;
}
