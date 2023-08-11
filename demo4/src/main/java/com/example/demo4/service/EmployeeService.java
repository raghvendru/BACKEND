package com.example.demo4.service;

import com.example.demo4.exception.ResourceNotFoundException;
import com.example.demo4.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmpById(long id) throws ResourceNotFoundException;

    Employee updateEmp(Employee employee,long id) throws ResourceNotFoundException;

    void deleteEmp(long id) throws ResourceNotFoundException;
}
