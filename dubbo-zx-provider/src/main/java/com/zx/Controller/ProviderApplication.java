package com.zx.Controller;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Auother zhangxing
 * @Date 2019-04-10 16:46
 * @note
 */
@SpringBootApplication
@EnableDubbo
@ComponentScan(value = "com.zx")
@DubboComponentScan(value = "com.zx.Service")
public class ProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class, args);
    }
}
