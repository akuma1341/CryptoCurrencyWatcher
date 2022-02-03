package com.example.cryptocurrencywatcher.repositories;

import com.example.cryptocurrencywatcher.entities.UsersCurrencyPrice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersCurrencyPricesRepository extends CrudRepository<UsersCurrencyPrice, Integer> {

//    @Query("select ucp from UsersCurrencyPrice ucp join fetch ucp.user join fetch ucp.currencyPrice where ucp.id=:id")
//    Optional<UsersCurrencyPrice> findById(int id);
}
