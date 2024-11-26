package org.example.eksamenkea;

import org.example.eksamenkea.repository.ProjectRepository;
import org.example.eksamenkea.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserApplicationTests {

    @Autowired
    UserRepository userRepository;
}
