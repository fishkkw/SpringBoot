package com.mrk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
@MapperScan("com.mrk.sys.dao") 
public class SpringbootMybatisApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext=SpringApplication.run(SpringbootMybatisApplication.class, args);
		applicationContext.getApplicationName(); 
	}
}
