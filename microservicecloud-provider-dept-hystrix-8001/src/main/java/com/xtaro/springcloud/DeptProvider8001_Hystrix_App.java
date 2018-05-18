package com.xtaro.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient			//注册入Eureka
@EnableDiscoveryClient		//服务发现
@EnableCircuitBreaker		//Hystrix熔断
@EnableHystrix
public class DeptProvider8001_Hystrix_App {
	
	public static void main(String[] args) {
		
		SpringApplication.run(DeptProvider8001_Hystrix_App.class, args);
	}

}
