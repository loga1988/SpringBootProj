package org.example.controller;

import org.example.entity.Employee;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee/details/")
public class SpringBootMainController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/{name}")
    public List<Employee> getEmployeeWelcome(@PathVariable("name") String name){
        return employeeService.getEmployee();
    }

    @PostMapping("/saveEmployee")
    public Employee saveEmployee(@RequestBody Employee emp){
     return employeeService.saveEmployee(emp);
    }
}
