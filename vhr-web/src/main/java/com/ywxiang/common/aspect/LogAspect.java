package com.ywxiang.common.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.ywxiang.common.annotation.SysLog;
import com.ywxiang.common.utils.HttpContextUtils;
import com.ywxiang.common.utils.IPUtils;
import com.ywxiang.entity.LogEntity;
import com.ywxiang.service.SysLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 系统日志切面类
 *
 * @author ywxiang
 * @date 2020/7/4 下午2:49
 */
@Slf4j
@Aspect
@Component
public class LogAspect {

    @Autowired
    private SysLogService sysLogService;

    @Pointcut("@annotation(com.ywxiang.common.annotation.SysLog)")
    public void logPointCut(){}

    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable{
        long beginTime = System.currentTimeMillis();
        // 执行方法
        Object result = point.proceed();
        long time = System.currentTimeMillis() - beginTime;
        saveSysLog(point, time);
        return result;
    }

    private void saveSysLog(ProceedingJoinPoint joinPoint, long time){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        LogEntity logEntity = new LogEntity();
        SysLog sysLog = method.getAnnotation(SysLog.class);
        if (sysLog != null){
            // 获取注解上的描述
            logEntity.setOperation(sysLog.value());
        }

        // 请求的方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        logEntity.setMethod(className + "." + methodName + "()");

        // 请求的参数
        Object[] args = joinPoint.getArgs();
        try {
            String params = JSON.toJSONString(args);
            logEntity.setParams(params);
        }catch (JSONException e){
            log.error(e.toString());
        }

        // 获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        // 获取IP地址
        logEntity.setIp(IPUtils.getIpAddr(request));

        // 用户
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        logEntity.setUsername(username);

        logEntity.setTime(time);
        logEntity.setCreateDate(new Date());
        // 保存
        sysLogService.addLog(logEntity);
    }

}
