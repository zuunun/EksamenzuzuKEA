package org.example.eksamenkea.service;

import org.example.eksamenkea.model.Employee;
import org.example.eksamenkea.repository.interfaces.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService  {
    private final IEmployeeRepository iEmployeeRepository;

    public EmployeeService(ApplicationContext context, @Value("IUSERREPOSITORY") String impl) {
        this.iEmployeeRepository = (IEmployeeRepository) context.getBean(impl);
    }

    //Sign in
    public Employee signIn(String email, String password) throws Errorhandling{
        return iEmployeeRepository.signIn(email, password);
    }
}
