package com.ywxiang.common.utils;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author ywxiang
 * @date 2020/8/1 下午12:35
 */
@Getter
@Setter
public class RespPageBean {
    private Long total;
    private List<?> data;
}
