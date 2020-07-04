package com.ywxiang.common.annotation;

import java.lang.annotation.*;

/**
 * 系统日志
 *
 * @author ywxiang
 * @date 2020/7/4 下午2:48
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {
    String value() default "";
}
