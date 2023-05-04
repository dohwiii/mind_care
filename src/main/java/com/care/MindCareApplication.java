package com.care;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@MapperScan("com.care.mapper")
@SpringBootConfiguration
@ComponentScan("com.care")
@EnableAutoConfiguration
public class MindCareApplication {
	public static void main(String[] args) {
		SpringApplication.run(MindCareApplication.class, args);
	}
}
