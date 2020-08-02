package com.ywxiang.common.Constant;

/**
 * @author ywxiang
 * @date 2020/8/2 下午2:25
 */
public interface MailConstants {
    /**
     * 消息投递中
     */
    Integer DELIVERING = 0;

    /**
     * 消息投递成功
     */
    Integer SUCCESS = 1;

    /**
     * 消息投递失败
     */
    Integer FAILURE = 2;

    /**
     * 最大重试次数
     */
    Integer MAX_TRY_COUNT = 3;

    /**
     * 消息超时时间
     */
    Integer MSG_TIMEOUT = 1;

    String MAIL_QUEUE_NAME = "ywxiang.mail.queue";

    String MAIL_EXCHANGE_NAME = "ywxiang.mail.exchange";

    String MAIL_ROUTING_KEY_NAME = "ywxiang.mail.routing.key";
}
