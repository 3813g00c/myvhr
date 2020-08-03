package com.ywxiang.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author ywxiang
 * @date 2020/8/3 下午8:53
 */
@Getter
@Setter
public class ChatMsg {
    private String from;
    private String to;
    private String content;
    private Date date;
    private String fromNickname;
}
