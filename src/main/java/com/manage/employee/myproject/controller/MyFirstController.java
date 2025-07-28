package com.manage.employee.myproject.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class MyFirstController {


  @GetMapping("/")
  public String getMethod() {
      return "Hello";
  }
  
}
