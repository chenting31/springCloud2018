package com.xtaro.myrule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;

@Configuration
public class MyDeptRuleCfg {

	//改变默认Ribbon轮询算法
		@Bean
		public IRule myRule() {
			//默认
			//return new RoundRobinRule();
			//return new RetryRule();
			//return new WeightedResponseTimeRule();
			return new MyDeptRule();
		}
}
