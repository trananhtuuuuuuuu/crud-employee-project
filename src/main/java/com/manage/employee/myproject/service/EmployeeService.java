package com.manage.employee.myproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.manage.employee.myproject.domain.Employee;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor

public class EmployeeService {
  //private final EmployeeRepository employeeRepository;

  public void saveEmployee(Employee employee){
    //this.employeeRepository.save(employee);
  }

  public void saveEmployeeUpdated(){
    // Employee temp = new Employee("Alex", "male", "alex@gmail.com", "01/01/2004", 20);
    // List<Employee> employees = new ArrayList<>();
    // employees.add(new Employee("Alex", "male", "alex@gmail.com", "01/01/2004", 20)
    // );

  }


  public List<Employee> createListEmployees(){
    List<Employee> employees = new ArrayList<>();
    employees.add(new Employee("Alex", "male", "alex@gmail.com", "01/01/2004", 20));
    employees.add(new Employee("Elex", "female", "elex@gmail.com", "02/02/2004", 22));
    employees.add(new Employee("Blex", "male", "blex@gmail.com", "03/03/2004", 23));
    employees.add(new Employee("Clex", "female", "clex@gmail.com", "04/04/2004", 24));
    employees.add(new Employee("Dlex", "female", "dlex@gmail.com", "05/05/2004", 25));

    return employees;
  }
}
