package org.example.eksamenkea.service;

import org.example.eksamenkea.model.User;
import org.example.eksamenkea.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Sign in
    public User signIn(String email, String password) {
        return userRepository.signIn(email, password);
    }
}
