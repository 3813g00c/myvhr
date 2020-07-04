package com.ywxiang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author ywxiang
 * @date 2020/7/4 下午12:02
 */


@SpringBootApplication
@EnableSwagger2
@MapperScan("com.ywxiang.dao")
public class VhrApplication {
    public static void main(String[] args) {
        SpringApplication.run(VhrApplication.class, args);
    }
}
