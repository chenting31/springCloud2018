package com.xtaro.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.xtaro.myrule.MyDeptRuleCfg;

@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration=MyDeptRuleCfg.class)
public class DeptConsumer81_App {

	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer81_App.class, args);
	}
}
