package org.example.eksamenkea;

import org.example.eksamenkea.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserApplicationTests {

    @Autowired
    EmployeeRepository employeeRepository;
}
