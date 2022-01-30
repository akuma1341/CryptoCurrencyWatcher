package com.example.cryptocurrencywatcher.repositories;

import com.example.cryptocurrencywatcher.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findUserByName(String name);
}
