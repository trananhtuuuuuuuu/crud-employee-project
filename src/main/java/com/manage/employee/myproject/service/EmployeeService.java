package com.manage.employee.myproject.service;

import org.springframework.stereotype.Service;

import com.manage.employee.myproject.domain.Employee;
import com.manage.employee.myproject.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class EmployeeService {
  private final EmployeeRepository employeeRepository;

  public void saveEmployee(Employee employee){
    this.employeeRepository.save(employee);
  }
}
