package com.manage.employee.myproject.repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manage.employee.myproject.domain.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

  
}