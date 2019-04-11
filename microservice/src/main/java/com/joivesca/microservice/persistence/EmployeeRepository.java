package com.joivesca.microservice.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.joivesca.microservice.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

}
