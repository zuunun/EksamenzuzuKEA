package org.example.eksamenkea;


import org.example.eksamenkea.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProjectApplicationTests {

	@Autowired
	ProjectRepository projectRepository;



}
