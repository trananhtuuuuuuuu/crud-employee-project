package com.manage.employee.myproject.controller;

import org.springframework.web.bind.annotation.RestController;

import com.manage.employee.myproject.domain.Employee;
import com.manage.employee.myproject.service.EmployeeService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;





@RestController
public class MyFirstController {

  private final EmployeeService employeeService;

  public MyFirstController(EmployeeService employeeService){
    this.employeeService = employeeService;
  }

  @GetMapping("/")
  public String getMethod() {
      return "Hello";
  }

  @GetMapping("/employees")
  public List<Employee> getEmployee() {
      return this.employeeService.createListEmployees();
  }

  @GetMapping("/employess/{employeeId}")
  public String getEmployee(@PathVariable long employeeId) {
      return "Hello";
  }
  


  
  
}
