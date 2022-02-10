package com.example.cryptocurrencywatcher.services;

import com.example.cryptocurrencywatcher.entities.CurrencyPrice;
import com.example.cryptocurrencywatcher.repositories.CurrencyPricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CurrencyPricesService {
    private final CurrencyPricesRepository currencyPricesRepository;

    @Autowired
    public CurrencyPricesService(CurrencyPricesRepository currencyPricesRepository) {
        this.currencyPricesRepository = currencyPricesRepository;
    }

    @Transactional
    public Iterable<CurrencyPrice> getCurrencyPrices() {
        return currencyPricesRepository.findAll();
    }

    @Transactional
    public CurrencyPrice getCurrencyPriceById(long id) {
        return currencyPricesRepository.findById(id).get();
    }

    @Transactional
    public CurrencyPrice getCurrencyPriceByIdWithFetch(long id) {
        return currencyPricesRepository.findByIdWithFetch(id).get();
    }

    @Transactional
    public void saveCurrencyPrice(CurrencyPrice currencyPrice) {
        currencyPricesRepository.save(currencyPrice);
    }
}
