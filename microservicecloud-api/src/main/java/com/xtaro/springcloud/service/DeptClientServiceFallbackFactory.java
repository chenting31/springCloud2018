package com.xtaro.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.xtaro.springcloud.entities.Dept;

import feign.hystrix.FallbackFactory;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService>{

	@Override
	public DeptClientService create(Throwable cause) {
		 
		return new DeptClientService() {

			@Override
			public Dept get(long id) {
				
				Dept dept = new Dept();
				dept.setDeptno(id);
				dept.setDname("Customers提供降级信息，Provider已经关闭");
				 
				return dept;
			}

			@Override
			public List<Dept> list() {
				 
				return null;
			}

			@Override
			public boolean add(Dept dept) {
				 
				return false;
			}

			@Override
			public String port() {
				 
				return null;
			}
			
		};
	}

}
