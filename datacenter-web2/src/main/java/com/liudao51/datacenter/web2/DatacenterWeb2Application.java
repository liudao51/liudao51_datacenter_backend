package com.liudao51.datacenter.web2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
//@ComponentScan(basePackages = {"com.liudao51.datacenter.web2"})
@ImportResource(locations = {"classpath:dubbo/consumer1.xml"})
public class DatacenterWeb2Application {
    public static void main(String[] args) {
        SpringApplication.run(DatacenterWeb2Application.class, args);

        System.out.println("DatacenterWeb2Application启动成功...");
    }
}
