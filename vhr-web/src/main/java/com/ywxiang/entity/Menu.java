package com.ywxiang.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/7/28 下午8:59
 */
@Getter
@Setter
public class Menu {
    private Integer id;

    private String url;

    private String path;

    private String component;

    private String name;

    private String iconCls;

    private Meta meta;

    private Integer parentId;

    private Boolean enabled;
    private List<Menu> children;
    private List<Role> roles;
}
