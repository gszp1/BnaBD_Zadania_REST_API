package org.example.zadania_rest_api.repository;

import org.example.zadania_rest_api.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e WHERE e.lastName LIKE ?1%")
    Iterable<Employee> findAllByFirstLetterOfLastName(char letter);
}
