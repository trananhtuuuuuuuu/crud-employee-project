package com.manage.employee.myproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.manage.employee.myproject.exception.define.EmployeeErrorResponse;
import com.manage.employee.myproject.exception.define.EmployeeNotFoundException;

@ControllerAdvice
public class EmployeeRestExceptionHandler {
  
  @ExceptionHandler
  public ResponseEntity<EmployeeErrorResponse> handleException(
    EmployeeNotFoundException exc
  ){

    EmployeeErrorResponse error = new EmployeeErrorResponse();

    error.setStatus(HttpStatus.BAD_REQUEST.value());
    error.setMessage(exc.getMessage());
    error.setTimeStamp(System.currentTimeMillis());

    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler
  public ResponseEntity<EmployeeErrorResponse> handleException(
    Exception exc
  ){

    EmployeeErrorResponse error = new EmployeeErrorResponse();

    error.setStatus(HttpStatus.NOT_FOUND.value());
    error.setMessage(exc.getMessage());
    error.setTimeStamp(System.currentTimeMillis());

    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }
}
