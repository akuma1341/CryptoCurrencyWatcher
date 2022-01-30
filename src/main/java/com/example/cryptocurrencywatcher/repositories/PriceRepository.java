package com.example.cryptocurrencywatcher.repositories;

import com.example.cryptocurrencywatcher.entities.Price;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends CrudRepository<Price, Integer> {
    Iterable<Price> findAllByCurrencyId(Integer currencyId);
}
