package com.example.cryptocurrencywatcher.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdaterThread extends Thread{
    private static final Logger LOGGER = LoggerFactory.getLogger(PricesUpdater.class);
    @Autowired
    private CurrencyPricesUpdater currencyPricesUpdater;
    @Autowired
    private ControllerOfPriceChangesForUsers controller;

    @Override
    public void run() {
        while (true) {
            try {
                currencyPricesUpdater.updatePrices();
                controller.checkPriceChangesForUsers();
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                LOGGER.error("UpdaterThread interrupted: " + e.getMessage());
            }
        }
    }
}
