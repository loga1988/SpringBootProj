package org.example.controller;

import jakarta.validation.Valid;
import org.example.entity.Employee;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
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
    public Employee saveEmployee(@RequestBody @Valid  Employee emp){
        return employeeService.saveEmployee(emp);
    }
}
