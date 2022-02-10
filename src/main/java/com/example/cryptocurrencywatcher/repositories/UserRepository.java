package com.example.cryptocurrencywatcher.repositories;

import com.example.cryptocurrencywatcher.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select user from User user join fetch user.usersCurrencyPrice where user.id=:id")
    Optional<User> findByIdWithFetch(long id);
}
