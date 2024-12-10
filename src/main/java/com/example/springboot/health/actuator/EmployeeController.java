package com.example.springboot.health.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// only extra actuator as dependency than jpa,maria etc
@RestController
public class EmployeeController
{
@Autowired
EmployeeRepository erepo;
@RequestMapping("/test")
public String test()
{
	return "this is actuator test";
}
@RequestMapping("/save")
public String save(@RequestBody Employee employee)
{
	erepo.save(employee);
	return "data saved into database";
}
//http://localhost:8080/actuator/health
// after adding two lines in application.properties 13 rest endpoints are use microsoft edge OK working this fine 
// http://localhost:8080/actuator/metrics for the metrics 
//http://localhost:8080/actuator/metrics/disk.free for disk free see the result here 
}
