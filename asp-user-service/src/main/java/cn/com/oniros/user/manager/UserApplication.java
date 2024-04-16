package cn.com.oniros.user.manager;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * cn.com.oniros.user.manager.UserApplication
 *
 * @author Li Xiaoxu
 * 2024/4/14 17:18
 */
@SpringBootApplication
@EnableDubbo
@MapperScan(basePackages = "cn.com.oniros.user.manager.dao")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
