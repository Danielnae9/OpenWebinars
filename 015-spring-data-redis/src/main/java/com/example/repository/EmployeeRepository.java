package com.example.repository;

import com.example.domain.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

    List<Employee> findTop3ByAge(Integer age);

}
