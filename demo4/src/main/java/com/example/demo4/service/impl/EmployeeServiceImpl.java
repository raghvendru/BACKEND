package com.example.demo4.service.impl;
import com.example.demo4.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo4.model.Employee;
import com.example.demo4.repository.EmployeeRepository;
import com.example.demo4.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmpById(long id) throws ResourceNotFoundException {
        return employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("employee","Id",id));
    }

    @Override
    public Employee updateEmp(Employee employee, long id) throws ResourceNotFoundException {
        Employee existingEmp = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("employee","id",id));
        existingEmp.setEmail(employee.getEmail());
        existingEmp.setFirstName(employee.getFirstName());
        existingEmp.setLastName(employee.getLastName());
        employeeRepository.save(existingEmp);
        return existingEmp;
    }

    @Override
    public void deleteEmp(long id) throws ResourceNotFoundException {
        //exist or not
       employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("employee","Id",id)) ;

        employeeRepository.deleteById(id);
    }
    }
