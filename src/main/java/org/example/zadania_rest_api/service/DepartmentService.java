package org.example.zadania_rest_api.service;

import org.example.zadania_rest_api.model.Department;
import org.example.zadania_rest_api.model.Employee;
import org.example.zadania_rest_api.repository.DepartmentRepository;
import org.example.zadania_rest_api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    private final EmployeeRepository employeeRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    public void addEmployeeToDepartment(Long departmentId, Employee employee) {
        Optional<Department> department = departmentRepository.findById(departmentId);
        department.ifPresent(dpt -> {
            dpt.getEmployees().add(employee);
            employee.setDepartment(dpt);
            departmentRepository.save(dpt);
            employeeRepository.save(employee);
        });
    }
}
