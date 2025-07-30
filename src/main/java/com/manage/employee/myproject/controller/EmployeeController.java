package com.manage.employee.myproject.controller;

import com.manage.employee.myproject.service.EmployeeService;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class EmployeeController {

  private final EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService){
    this.employeeService = employeeService;
  }

  @GetMapping("/")
  public String getMethod() {
      return "dashboard";
  }



  
    
  


  
  
}
