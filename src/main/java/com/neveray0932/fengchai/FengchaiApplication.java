package com.neveray0932.fengchai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.neveray0932.fengchai.mapper")
public class FengchaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FengchaiApplication.class, args);
    }

}
