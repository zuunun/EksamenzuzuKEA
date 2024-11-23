package org.example.eksamenkea.repository.interfaces;

import org.example.eksamenkea.model.User;
import org.example.eksamenkea.service.Errorhandling;

public interface IUserRepository {
    User signIn(String email, String password) throws Errorhandling;
}
