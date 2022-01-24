package com.example.project.service.impl;

import com.example.project.model.User;
import com.example.project.model.exceptions.InvalidArgumentsException;
import com.example.project.model.exceptions.InvalidUserCredentialsException;
import com.example.project.model.exceptions.PasswordsDoNotMatchException;
import com.example.project.model.exceptions.UsernameExistsException;
import com.example.project.repository.UserRepository;
import com.example.project.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User login(String username, String password) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        return userRepository.findByUsernameAndPassword(username, password).orElseThrow(InvalidUserCredentialsException::new);
    }

    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname) {
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new InvalidArgumentsException();
        }
        if (!password.equals(repeatPassword)) {
            throw new PasswordsDoNotMatchException();
        }

        if (this.userRepository.findByUsername(username).isPresent() ||
                !this.userRepository.findByUsername(username).isEmpty()) {
            throw new UsernameExistsException(username);
        }

        User user = new User(username, password, name, surname);
        return userRepository.saveOrUpdate(user);
    }
}

