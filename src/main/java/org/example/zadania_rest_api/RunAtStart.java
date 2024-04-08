package org.example.zadania_rest_api;

import org.example.zadania_rest_api.model.Employee;
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
    public CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
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
        };
    }
}
