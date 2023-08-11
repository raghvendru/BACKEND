package com.example.demo4.controller;

import com.example.demo4.exception.ResourceNotFoundException;
import com.example.demo4.model.Employee;
import com.example.demo4.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    public  EmployeeController (EmployeeService employeeService){
        super();
        this.employeeService=employeeService;
    }

    //build create employee rest
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee( @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }


    //get all list of employees
    @GetMapping()
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployees();
    }

    //by id
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmpById(@PathVariable("id")long employeeId) throws ResourceNotFoundException {
        return new ResponseEntity<Employee>(employeeService.getEmpById(employeeId),HttpStatus.OK);

    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee) throws ResourceNotFoundException {
        return new ResponseEntity<Employee>(employeeService.updateEmp(employee,id),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmp(@PathVariable("id") long id) throws ResourceNotFoundException {
        employeeService.deleteEmp(id);
        return new ResponseEntity<String>("emp delete",HttpStatus.OK);
    }
}
