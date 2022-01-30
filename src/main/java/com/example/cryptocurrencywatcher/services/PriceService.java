package com.example.cryptocurrencywatcher.services;

import com.example.cryptocurrencywatcher.entities.Price;
import com.example.cryptocurrencywatcher.repositories.PriceRepository;
import com.example.cryptocurrencywatcher.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceService {
    @Autowired
    private PriceRepository priceRepository;
    @Autowired
    private UserRepository userRepository;


    public Iterable<Price> getPrices() {
        return priceRepository.findAll();
    }

    public Price getPriceById(int priceId) {
        return priceRepository.findById(priceId).get();
    }

    public Iterable<Price> getPricesByUser(String userName) {
        int currencyId = userRepository.findUserByName(userName).getPrice().getCurrency().getId();
        return priceRepository.findAllByCurrencyId(currencyId);
    }

    public void savePrice(Price price) {
        priceRepository.save(price);
    }
}
