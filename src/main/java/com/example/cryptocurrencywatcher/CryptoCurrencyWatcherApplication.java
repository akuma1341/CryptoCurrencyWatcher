package com.example.cryptocurrencywatcher;

import com.example.cryptocurrencywatcher.data.UpdaterThread;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CryptoCurrencyWatcherApplication{

    public static void main(String[] args){
        ApplicationContext applicationContext = SpringApplication.run(CryptoCurrencyWatcherApplication.class, args);

        UpdaterThread updaterThread = applicationContext.getBean(UpdaterThread.class);
        updaterThread.start();
    }
}
