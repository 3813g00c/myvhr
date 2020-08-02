package com.ywxiang.service.impl;

import com.ywxiang.common.Constant.MailConstants;
import com.ywxiang.dao.EmployDao;
import com.ywxiang.entity.Employee;
import com.ywxiang.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author ywxiang
 * @date 2020/8/1 下午12:19
 */
@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployDao employDao;

    @Autowired
    RabbitTemplate rabbitTemplate;

    SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
    SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
    DecimalFormat decimalFormat = new DecimalFormat("##.00");

    @Override
    public List<Employee> getAllEmployees(Employee employee, Date[] beginDateScope) {
        return employDao.getAllEmployees(employee, beginDateScope);
    }

    @Override
    public Integer addEmps(List<Employee> list) {
        return employDao.addEmps(list);
    }

    @Override
    public Integer addEmp(Employee employee) {
        Date beginContract = employee.getBeginContract();
        Date endContract = employee.getEndContract();
        double month = (Double.parseDouble(yearFormat.format(endContract))
                - Double.parseDouble(yearFormat.format(beginContract))) * 12
                + (Double.parseDouble(monthFormat.format(endContract))
                - Double.parseDouble(monthFormat.format(beginContract)));
        employee.setContractTerm(Double.parseDouble(decimalFormat.format(month / 12)));
        int result = employDao.insertSelective(employee);
        if (result == 1) {
            Employee emp = employDao.getEmployeeById(employee.getId());
            // 生成消息的唯一ID
            String msgId = UUID.randomUUID().toString();
            rabbitTemplate.convertAndSend(MailConstants.MAIL_EXCHANGE_NAME, MailConstants.MAIL_ROUTING_KEY_NAME,
                    emp, new CorrelationData(msgId));
            log.info("发送邮件");
        }
        return result;
    }
}
