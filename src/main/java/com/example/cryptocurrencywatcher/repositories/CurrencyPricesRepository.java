package com.example.cryptocurrencywatcher.repositories;

import com.example.cryptocurrencywatcher.entities.CurrencyPrice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyPricesRepository extends CrudRepository<CurrencyPrice, Integer> {
}
