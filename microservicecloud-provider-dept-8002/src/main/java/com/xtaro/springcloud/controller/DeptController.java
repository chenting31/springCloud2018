package com.xtaro.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xtaro.springcloud.entities.Dept;
import com.xtaro.springcloud.service.DeptService;

@RestController
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Value("${server.port}")
	private String port;
	
	
	@RequestMapping(value="dept/add",method=RequestMethod.POST)
	public boolean add(@RequestBody Dept dept) {
		
		return deptService.add(dept);
	}
	
	@RequestMapping(value="dept/get/{id}",method=RequestMethod.GET)
	public Dept get(@PathVariable Long id) {

		return deptService.get(id);
	}
	
	
	@RequestMapping(value="dept/list",method=RequestMethod.GET)
	public List<Dept> list() {
		
		return deptService.list();
	}
	
	@RequestMapping(value="dept/port",method=RequestMethod.GET)
	public String port() {
		
		return port;
	}
	
	//服务端服务发现
	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object discovery()
	{
		List<String> list = discoveryClient.getServices();
		System.out.println("**********" + list);

		List<ServiceInstance> srvList = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.discoveryClient;
	}


}
