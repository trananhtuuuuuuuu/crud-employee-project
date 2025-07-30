package com.manage.employee.myproject.service;


import org.springframework.security.core.userdetails.UserDetailsService;

import com.manage.employee.myproject.DTO.UserRegistrationDto;
import com.manage.employee.myproject.domain.User;

public interface UserService extends UserDetailsService {
  User save(UserRegistrationDto registrationDto);
}
