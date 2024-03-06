package org.example.service;

import org.example.entity.Employee;

import java.util.List;

public interface EmployeeService {
     List<Employee> getEmployee();
     Employee saveEmployee(Employee emp);
}
