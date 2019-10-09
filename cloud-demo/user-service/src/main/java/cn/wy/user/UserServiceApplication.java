package cn.wy.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author WY
 * @Date 2019/9/27
 **/
@SpringBootApplication
@MapperScan(basePackages = "cn.wy.user.mapper")
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class UserServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
}
