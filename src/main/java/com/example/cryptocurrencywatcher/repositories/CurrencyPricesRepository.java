package com.example.cryptocurrencywatcher.repositories;

import com.example.cryptocurrencywatcher.entities.CurrencyPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyPricesRepository extends JpaRepository<CurrencyPrice, Long> {
    @Query("select cp from CurrencyPrice cp join fetch cp.usersCurrencyPrice where cp.id=:id")
    Optional<CurrencyPrice> findByIdWithFetch(Long id);
}
