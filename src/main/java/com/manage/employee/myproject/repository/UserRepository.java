package com.manage.employee.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.manage.employee.myproject.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
  
  User findByEmail(String email);
}
