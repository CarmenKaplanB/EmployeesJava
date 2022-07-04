package com.example.springboot.app.service;

import com.example.springboot.app.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    List<Employee> getAllEmployee();

    Employee getEmployeeById(long employeeId);

    void deleteEmployee(long employeeId);
}
