package com.lk.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@ServletComponentScan
@EnableConfigurationProperties
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        // 三种启动方式
        SpringApplication.run(Main.class);
    }
}
