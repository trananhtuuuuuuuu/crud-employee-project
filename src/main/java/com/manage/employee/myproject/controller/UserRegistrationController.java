package com.manage.employee.myproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manage.employee.myproject.DTO.UserRegistrationDto;
import com.manage.employee.myproject.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/registration")
public class UserRegistrationController  {

  private final UserService userService;

  public UserRegistrationController(UserService userService){
    this.userService = userService;
  }

  @ModelAttribute("user")
  public UserRegistrationDto userRegistrationDto() {
      return new UserRegistrationDto();
  }

  @GetMapping
  public String showRegistrationForm() {
    return "registration";
  }

  @PostMapping
  public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto, 
                                  RedirectAttributes redirectAttributes) {
    try {
      this.userService.save(registrationDto);
      
      
      redirectAttributes.addFlashAttribute("successMessage", "Registration successful!");
      
      return "redirect:/registration";
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("errorMessage", "Registration failed. Please try again.");
      return "redirect:/registration";
    }
  }
  

}
