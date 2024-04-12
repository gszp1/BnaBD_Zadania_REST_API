package org.example.zadania_rest_api;

import org.example.zadania_rest_api.model.Department;
import org.example.zadania_rest_api.model.Employee;
import org.example.zadania_rest_api.repository.DepartmentRepository;
import org.example.zadania_rest_api.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@Component
public class RunAtStart {

    @Bean
    public CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository,
                                               DepartmentRepository departmentRepository) {
        return args -> {
            employeeRepository.saveAll(Arrays.asList(
                            new Employee(
                                    "Tomasz",
                                    "Nowak",
                                    new BigDecimal("4500.00"),
                                    LocalDate.of(2024, 3, 2)
                            ),
                            new Employee(
                                    "Jan",
                                    "Kowalski",
                                    new BigDecimal("3699.45"),
                                    LocalDate.of(2019, 12, 23)
                            )
                    )
            );
            departmentRepository.saveAll(Arrays.asList(
                            new Department(
                                    "SoftwareDevelopment",
                                    "DepartmentDescription",
                                    new BigDecimal("100000.0"),
                                    LocalDate.of(1999, 12, 1)
                            ),
                            new Department(
                                    "DataAnalysis",
                                    "DepartmentDescription",
                                    new BigDecimal("200000"),
                                    LocalDate.of(2001, 1, 12)
                            )
                    )
            );

        };
    }
}
