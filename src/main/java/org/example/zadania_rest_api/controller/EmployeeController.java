package org.example.zadania_rest_api.controller;

import org.example.zadania_rest_api.model.Employee;
import org.example.zadania_rest_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    public EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/id")
    public Optional<Employee> getEmployeeById(@RequestParam Long employeeId) {
        return employeeService.findById(employeeId);
    }

    @GetMapping("/{employeeId}")
    public Optional<Employee> getEmployeeByEmployeeId(@PathVariable Long employeeId) {
        return employeeService.findById(employeeId);
    }
//
//    @PostMapping("/add")
//
//    @DeleteMapping("/delete")
//
//    @PutMapping("/put")
}
