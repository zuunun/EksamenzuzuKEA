package org.example.eksamenkea.service;

import org.example.eksamenkea.model.User;
import org.example.eksamenkea.repository.UserRepository;
import org.example.eksamenkea.repository.interfaces.IUserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class UserService  {
    private final IUserRepository iuserRepository;

    public UserService(ApplicationContext context, @Value("DEPARTMENT_REPOSITORY_STUB") String impl) {
        this.iuserRepository = (IUserRepository) context.getBean(impl);
    }

    //Sign in
    public User signIn(String email, String password) throws Errorhandling{
        return iuserRepository.signIn(email, password);
    }
}
