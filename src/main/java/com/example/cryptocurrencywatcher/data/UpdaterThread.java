package com.example.cryptocurrencywatcher.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class UpdaterThread extends Thread{
    @Autowired
    private PriceUpdater priceUpdater;

    @Override
    public void run() {
        while (true) {
            try {
                priceUpdater.updatePrices();
                priceUpdater.checkPriceChangesForUsers();
                Thread.sleep(60000);
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }
    }
}
