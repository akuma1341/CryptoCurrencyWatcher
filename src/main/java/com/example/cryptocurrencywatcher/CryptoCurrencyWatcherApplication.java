package com.example.cryptocurrencywatcher;

import com.example.cryptocurrencywatcher.data.PriceUpdater;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class CryptoCurrencyWatcherApplication{

    public static void main(String[] args){
        ApplicationContext applicationContext = SpringApplication.run(CryptoCurrencyWatcherApplication.class, args);

        PriceUpdater priceUpdater = applicationContext.getBean(PriceUpdater.class);
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    priceUpdater.updatePrices();
                    priceUpdater.checkPriceChanges();
                    Thread.sleep(60000);
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

}
