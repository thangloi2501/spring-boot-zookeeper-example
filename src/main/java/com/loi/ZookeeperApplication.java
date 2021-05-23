package com.loi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableAutoConfiguration
@EnableFeignClients(basePackages={ "com.loi.client" })
@SpringBootApplication
public class ZookeeperApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZookeeperApplication.class, args);
	}
}