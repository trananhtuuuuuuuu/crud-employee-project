package com.manage.employee.myproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @GetMapping("/login")
  public String getLogin() {
      return "login";
  }
  
  
}
