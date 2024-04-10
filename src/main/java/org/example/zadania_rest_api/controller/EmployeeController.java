package org.example.zadania_rest_api.controller;

import org.example.zadania_rest_api.model.Employee;
import org.example.zadania_rest_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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
    public Optional<Employee> getEmployeeById(@RequestParam("employeeId") Long employeeId) {
        return employeeService.findById(employeeId);
    }

    @GetMapping("/salaryBetween")
    public List<Employee> getEmployeeBySalaryBetween(@RequestParam("minSalary") BigDecimal minSalary,
                                                     @RequestParam("maxSalary") BigDecimal maxSalary) {
        return employeeService.findBySalaryBetween(minSalary, maxSalary);
    }

    @GetMapping("/{employeeId}")
    public Optional<Employee> getEmployeeByEmployeeId(@PathVariable Long employeeId) {
        return employeeService.findById(employeeId);
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @DeleteMapping("/delete")
    public void deleteEmployeeById(@RequestParam("employeeId") Long employeeId) {
        employeeService.deleteById(employeeId);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }
}
