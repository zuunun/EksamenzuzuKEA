package org.example.eksamenkea.service;

import org.example.eksamenkea.model.Employee;
import org.example.eksamenkea.repository.interfaces.IUserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class UserService  {
    private final IUserRepository iuserRepository;

    public UserService(ApplicationContext context, @Value("IUSERREPOSITORY") String impl) {
        this.iuserRepository = (IUserRepository) context.getBean(impl);
    }

    //Sign in
    public Employee signIn(String email, String password) throws Errorhandling{
        return iuserRepository.signIn(email, password);
    }
}
