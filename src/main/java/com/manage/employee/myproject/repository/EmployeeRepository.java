package com.manage.employee.myproject.repository;



import org.springframework.data.jpa.repository.JpaRepository;



import com.manage.employee.myproject.domain.Employee;



public interface EmployeeRepository extends JpaRepository<Employee, Long> {

  
}