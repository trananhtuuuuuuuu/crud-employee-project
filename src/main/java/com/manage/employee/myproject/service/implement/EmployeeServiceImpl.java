package com.manage.employee.myproject.service.implement;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.manage.employee.myproject.domain.Employee;
import com.manage.employee.myproject.repository.EmployeeRepository;
import com.manage.employee.myproject.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepository employeeRepository;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository){
    this.employeeRepository = employeeRepository;
  }

  @Override
  public List<Employee> getAllEmployees(){
    return this.employeeRepository.findAll();
  }

  @Override
  public void saveEmployee(Employee employee){
    this.employeeRepository.save(employee);
  }


  @Override
  public Employee getEmployeeById(long employeeId){
    Optional<Employee> optional = this.employeeRepository.findById(employeeId);
    Employee employee = null;
    if(optional.isPresent()){
      employee = optional.get();
    }
    else{
      throw new RuntimeException("Employee not found for id :: " + employeeId);
    }

    return employee;
  }


  @Override
  public void deleteEmployeeById(long employeeId){
    this.employeeRepository.deleteById(employeeId);
  }


  @Override
    public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
            Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.employeeRepository.findAll(pageable);
    }


  
}
