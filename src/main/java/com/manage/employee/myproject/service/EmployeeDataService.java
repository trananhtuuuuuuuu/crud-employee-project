package com.manage.employee.myproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.manage.employee.myproject.domain.Employee;
import com.manage.employee.myproject.repository.EmployeeRepository;



@Service
public class EmployeeDataService {
  private final EmployeeRepository employeeRepository;

  public EmployeeDataService(EmployeeRepository employeeRepository){
    this.employeeRepository = employeeRepository;
  }
  public void saveEmployee(Employee employee){
    this.employeeRepository.save(employee);
  }

  public void saveListEmployeeUpdated(List<Employee> employees){
    for(Employee e : employees){
      this.employeeRepository.save(e);
    }

  }


  
}
