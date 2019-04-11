package com.joivesca.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.joivesca.microservice.model.Employee;
import com.joivesca.microservice.persistence.EmployeeRepository;

@Component
@ConfigurationProperties
@RestController
public class EmployeeController {
	
	@Value("${application.message}")
	String message;

	@Value("${application.appname}")
	String appname;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@RequestMapping("/")
	String home() {
		return "Hello world!- " + message + " " + appname;
	}
	
	@RequestMapping(value="/employee", method = RequestMethod.POST)
	public Employee create(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{employee}")
	public Employee get(@PathVariable String employeeId) {
		return employeeRepository.findOne(employeeId);
	}
}
