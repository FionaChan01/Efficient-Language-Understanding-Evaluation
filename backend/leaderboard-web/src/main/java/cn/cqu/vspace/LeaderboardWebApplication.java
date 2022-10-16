package cn.cqu.vspace;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//启用springboot
@SpringBootApplication
//启动dubbo
@EnableDubbo
public class LeaderboardWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(LeaderboardWebApplication.class,args);
    }
}
