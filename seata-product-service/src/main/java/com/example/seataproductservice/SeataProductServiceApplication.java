package com.example.seataproductservice;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoDataSourceProxy
public class SeataProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataProductServiceApplication.class, args);
    }

}
