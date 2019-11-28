package com.liudao51.datacenter.core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@ComponentScan(basePackages = {"com.liudao51"})
@MapperScan({"com.liudao51.datacenter.core.mapper"})
public class DatacenterCoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(DatacenterCoreApplication.class, args);
    }
}
