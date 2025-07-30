package com.manage.employee.myproject.controller;

import org.springframework.web.bind.annotation.RestController;

import com.manage.employee.myproject.domain.Employee;
import com.manage.employee.myproject.exception.define.EmployeeNotFoundException;
import com.manage.employee.myproject.service.EmployeeDataService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
public class EmployeeController {

  private final EmployeeDataService employeeService;

  public EmployeeController(EmployeeDataService employeeService){
    this.employeeService = employeeService;
  }

  @GetMapping("/")
  public String getMethod() {
      return "dashboard";
  }
  
    
  


  
  
}
