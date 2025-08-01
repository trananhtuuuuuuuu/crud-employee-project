package com.manage.employee.myproject.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationDto {
  private String firstName;
  private String lastName;
  private String email;
  private String password;

  public UserRegistrationDto(){

  }

  public UserRegistrationDto(String firstName,
  String lastName, String email, String password){
    super(); // redundant
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
  }
}
