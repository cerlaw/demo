package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhanghongjie
 * 程序入口
 */

/**
 * 注解：开启组件扫描和自动配置
 * 相当于将Spring三个有用的注解组合在一起
 * @Configuration： 表明该类使用Spring基于Java配置（Spring）
 * @ComponentScan: 启用组件扫描，这样你写的Web控制器类和其他组件才能被自动发现并注册为Spring应用程序上下文里的Bean（Spring）
 * @EnableAutoConfiguration： 开启Spring boot自动配置（Spring boot）
 */
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		//负责启动引导应用程序
		SpringApplication.run(DemoApplication.class, args);
	}
}
