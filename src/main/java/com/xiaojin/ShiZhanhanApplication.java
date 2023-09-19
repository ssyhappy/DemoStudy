package com.xiaojin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.xiaojin.dao")
public class ShiZhanhanApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShiZhanhanApplication.class, args);
    }
}
