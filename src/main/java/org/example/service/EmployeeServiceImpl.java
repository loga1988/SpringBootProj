package org.example.service;

import org.example.entity.Employee;
import org.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public List<Employee> getEmployee() {
        return (List<Employee>)employeeRepository.findAll();
    }

    @Override
    public Employee saveEmployee(@Validated(Employee.class) Employee emp) {
        return employeeRepository.save(emp);
    }

}
