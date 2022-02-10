package com.example.cryptocurrencywatcher.services;

import com.example.cryptocurrencywatcher.entities.User;
import com.example.cryptocurrencywatcher.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public User getUserById(long id) {
        return userRepository.findById(id).get();
    }

    @Transactional
    public User getUserByIdWithFetch(long id) {
        return userRepository.findByIdWithFetch(id).get();
    }

    @Transactional
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
