package com.example.cryptocurrencywatcher.services;

import com.example.cryptocurrencywatcher.entities.Currency;
import com.example.cryptocurrencywatcher.entities.Price;
import com.example.cryptocurrencywatcher.repositories.CurrencyRepository;
import com.example.cryptocurrencywatcher.repositories.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CurrencyService {

    private final CurrencyRepository currencyRepository;
    private final PriceRepository priceRepository;

    @Autowired
    public CurrencyService(CurrencyRepository currencyRepository, PriceRepository priceRepository) {
        this.currencyRepository = currencyRepository;
        this.priceRepository = priceRepository;
    }

    public Iterable<Currency> getCurrencies() {
        return currencyRepository.findAll();
    }

    public Currency getCurrencyById(int currencyId) {
        return currencyRepository.findById(currencyId).get();
    }

    public Price getCurrencyInfo(Integer currencyId) {
        List<Price> prices = new ArrayList<>();
        priceRepository.findAllByCurrencyId(currencyId).forEach(prices::add);
        return prices.stream()
                .max(Comparator.comparingInt(Price::getId)).get();
    }

    public Set<Price> getActualPrices() {
        List<Price> prices = new ArrayList<>();
        priceRepository.findAll().forEach(prices::add);
        return prices.stream()
                .sorted(Comparator.comparingInt(Price::getId).reversed())
                .limit(3)
                .collect(Collectors.toSet());
    }
}
