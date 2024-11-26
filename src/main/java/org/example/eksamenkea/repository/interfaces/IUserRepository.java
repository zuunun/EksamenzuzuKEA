package org.example.eksamenkea.repository.interfaces;

import org.example.eksamenkea.model.Employee;
import org.example.eksamenkea.service.Errorhandling;

public interface IUserRepository {
    Employee signIn(String email, String password) throws Errorhandling;
}
