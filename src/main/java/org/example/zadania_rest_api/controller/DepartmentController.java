package org.example.zadania_rest_api.controller;

import org.example.zadania_rest_api.model.Department;
import org.example.zadania_rest_api.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/all")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Optional<Department> getDepartmentByIdPath(@PathVariable("id") Long id) {
        return departmentService.getDepartmentById(id);
    }

    @GetMapping("/id")
    public Optional<Department> getDepartmentByIdParam(@RequestParam("id") Long id) {
        return departmentService.getDepartmentById(id);
    }

    @PostMapping("/add")
    public Department addDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @DeleteMapping("/delete")
    public void deleteDepartmentById(@RequestParam("id") Long id) {
        departmentService.deleteDepartmentById(id);
    }

    @PutMapping("/update")
    public Department updateDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }
}
