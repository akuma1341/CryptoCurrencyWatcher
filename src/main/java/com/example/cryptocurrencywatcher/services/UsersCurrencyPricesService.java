package com.example.cryptocurrencywatcher.services;

import com.example.cryptocurrencywatcher.entities.UsersCurrencyPrice;
import com.example.cryptocurrencywatcher.repositories.UsersCurrencyPricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersCurrencyPricesService {
    private final UsersCurrencyPricesRepository usersCurrencyPricesRepository;

    @Autowired
    public UsersCurrencyPricesService(UsersCurrencyPricesRepository usersCurrencyPricesRepository) {
        this.usersCurrencyPricesRepository = usersCurrencyPricesRepository;
    }

    @Transactional
    public Iterable<UsersCurrencyPrice> findAll() {
        return usersCurrencyPricesRepository.findAll();
    }

    @Transactional
    public UsersCurrencyPrice findById(long id) {
        return usersCurrencyPricesRepository.findById(id).get();
    }

    @Transactional
    public UsersCurrencyPrice save(UsersCurrencyPrice usersCurrencyPrice) {
        return usersCurrencyPricesRepository.save(usersCurrencyPrice);
    }

    @Transactional
    public void delete(long id) {
        usersCurrencyPricesRepository.deleteById(id);
    }
}
