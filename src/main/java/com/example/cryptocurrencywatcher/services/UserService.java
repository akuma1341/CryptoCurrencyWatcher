package com.example.cryptocurrencywatcher.services;

import com.example.cryptocurrencywatcher.entities.User;
import com.example.cryptocurrencywatcher.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }

    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
