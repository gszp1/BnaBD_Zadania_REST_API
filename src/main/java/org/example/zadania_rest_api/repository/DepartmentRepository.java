package org.example.zadania_rest_api.repository;

import org.example.zadania_rest_api.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
