package com.liudao51.datacenter.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = {"classpath:dubbo/provider1.xml"})

//不建议使用@MapperScan来扫描Mapper类, 建议直接在Mapper类上使用@Mapper注解(且@MapperScan与@Mapper只能选其中一个)
//@MapperScan(basePackages="com.liudao51.datacenter.biz")

//不建议使用ComponentScan来扫描Component类, 建议直接在Component类上使用@Controller,@Service,@Repository,@Mapper,@Component注解
//@ComponentScan(basePackages="com.liudao51.datacenter.biz")
public class DatacenterBizApplication {
    public static void main(String[] args) {
        SpringApplication.run(DatacenterBizApplication.class, args);
        System.out.println("服务提供者启动成功...");
    }
}




