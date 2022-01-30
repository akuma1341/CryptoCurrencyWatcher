package com.example.cryptocurrencywatcher.repositories;

import com.example.cryptocurrencywatcher.entities.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency, Integer>{
}
