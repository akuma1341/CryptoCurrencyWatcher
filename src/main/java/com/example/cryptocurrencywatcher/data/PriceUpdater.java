package com.example.cryptocurrencywatcher.data;

import com.example.cryptocurrencywatcher.entities.Currency;
import com.example.cryptocurrencywatcher.entities.Price;
import com.example.cryptocurrencywatcher.entities.User;
import com.example.cryptocurrencywatcher.repositories.UserRepository;
import com.example.cryptocurrencywatcher.services.CurrencyService;
import com.example.cryptocurrencywatcher.services.PriceService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PriceUpdater {
    private static final Logger LOGGER = LoggerFactory.getLogger(PriceUpdater.class);

    @Autowired
    private PriceService priceService;
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private UserRepository userRepository;

    public void updatePrices() throws IOException {
        String url = "https://api.coinlore.net/api/ticker/?id=";
        for (Currency currency : currencyService.getCurrencies()) {
            int currencyId = currency.getId();
            String currentURL = url + currencyId;
            JSONObject json = JsonReader.readJsonFromUrl(currentURL);
            double currentPrice = json.getDouble("price_usd");

            Price price = new Price();
            price.setPrice(currentPrice);
            price.setCurrency(currencyService.getCurrencyById(currencyId));
            priceService.savePrice(price);
            LOGGER.info("Updated price: " + price);
        }
    }

    public void checkPriceChangesForUsers() {
        for (User user : userRepository.findAll()) {

            Price price = priceService.getPriceById(user.getPrice().getId());
            double userStartPrice = price.getPrice();
            double currentPrice = currencyService.getCurrencyInfo(price.getCurrency().getId()).getPrice();
            double percent = changesInPercent(userStartPrice, currentPrice);

            if (Math.abs(percent) >= 1)
                LOGGER.warn(String.format("%s|%s|%.2f",
                        price.getCurrency().getSymbol(), user.getName(), percent));
        }
    }

    public double changesInPercent(double firstPrice, double secondPrice) {
        return secondPrice / firstPrice * 100 - 100;
    }
}
