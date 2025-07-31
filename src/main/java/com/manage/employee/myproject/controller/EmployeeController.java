package com.manage.employee.myproject.controller;

import com.manage.employee.myproject.domain.Employee;
import com.manage.employee.myproject.service.EmployeeService;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;





@Controller
public class EmployeeController {

  private final EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService){
    this.employeeService = employeeService;
  }

  @GetMapping("/")
  public String getViewHomePage(Model model) {
    Page<Employee> page = this.employeeService.findPaginated(1, 5, "firstName", "asc");
    
    // Debug logging
    System.out.println("=== DEBUG INFO ===");
    System.out.println("Total employees: " + page.getTotalElements());
    System.out.println("Employees on this page: " + page.getContent().size());
    System.out.println("Current page: " + (page.getNumber() + 1));
    System.out.println("Total pages: " + page.getTotalPages());
    
    if (!page.getContent().isEmpty()) {
        System.out.println("First employee: " + page.getContent().get(0).getFirstName());
    }

    model.addAttribute("listEmployees", page.getContent());
    model.addAttribute("currentPage", page.getNumber() + 1);
    model.addAttribute("totalPages", page.getTotalPages());
    model.addAttribute("totalItems", page.getTotalElements());
    model.addAttribute("sortField", "firstName");
    model.addAttribute("sortDir", "asc");
    model.addAttribute("reverseSortDir", "desc");
    
    return "index";
  }


  @GetMapping("/showNewEmployeeForm")
  public String showNewEmployeeForm(Model model) {
    Employee employee = new Employee();
    model.addAttribute("employee", employee);
    return "new_employee";
  }

  @PostMapping("/saveEmployee")
  public String saveEmployee(@ModelAttribute("employee") Employee employee) {
    this.employeeService.saveEmployee(employee);
    return "redirect:/";
  }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
      Employee employee = employeeService.getEmployeeById(id);
      model.addAttribute("employee", employee);
      return "update_employee";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {
      employeeService.deleteEmployeeById(id);
      return "redirect:/";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
            @RequestParam("sortField") String sortField,
            @RequestParam("sortDir") String sortDir,
            Model model) {
      int pageSize = 5;

      Page<Employee> page = employeeService.findPaginated(pageNo, pageSize, sortField, sortDir);
      List<Employee> listEmployees = page.getContent();

      model.addAttribute("currentPage", pageNo);
      model.addAttribute("totalPages", page.getTotalPages());
      model.addAttribute("totalItems", page.getTotalElements());

      model.addAttribute("sortField", sortField);
      model.addAttribute("sortDir", sortDir);
      model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

      model.addAttribute("listEmployees", listEmployees);
      return "index";
    }

 
  



  
    
  


  
  
}
