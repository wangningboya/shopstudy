package cn.wy.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author WY
 * @Date 2019/9/27
 **/
//@EnableEurekaClient
//通用 兼容zookeeper
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan(basePackages = "cn.wy.user.mapper")
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class UserServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
}
