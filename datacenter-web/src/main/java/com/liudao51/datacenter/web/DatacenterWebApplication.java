package com.liudao51.datacenter.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

//这里不需要连接数据库,所以需要加上(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ImportResource(locations = {"classpath:dubbo/consumer1.xml"})

//不建议使用@MapperScan来扫描Mapper类, 建议直接在Mapper类上使用@Mapper注解(且@MapperScan与@Mapper只能选其中一个)
//@MapperScan(basePackages="com.liudao51.datacenter.biz")

//不建议使用ComponentScan来扫描Component类, 建议直接在Component类上使用@Controller,@Service,@Repository,@Mapper,@Component注解
//@ComponentScan(basePackages="com.liudao51.datacenter.biz")
public class DatacenterWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(DatacenterWebApplication.class, args);
        System.out.println("服务消费者启动成功...");
    }
}
