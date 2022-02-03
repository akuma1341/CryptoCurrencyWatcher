package com.example.cryptocurrencywatcher.data;

import com.example.cryptocurrencywatcher.entities.CurrencyPrice;
import com.example.cryptocurrencywatcher.entities.UsersCurrencyPrice;
import com.example.cryptocurrencywatcher.services.CurrencyPricesService;
import com.example.cryptocurrencywatcher.services.UsersCurrencyPricesService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PricesUpdater implements CurrencyPricesUpdater, ControllerOfPriceChangesForUsers {
    private static final Logger LOGGER = LoggerFactory.getLogger(PricesUpdater.class);
    private final String mainURL = "https://api.coinlore.net/api/ticker/?id=";

    private final CurrencyPricesService currencyPricesService;
    private final UsersCurrencyPricesService usersCurrencyPricesService;

    @Autowired
    public PricesUpdater(CurrencyPricesService currencyPricesService, UsersCurrencyPricesService usersCurrencyPricesService) {
        this.currencyPricesService = currencyPricesService;
        this.usersCurrencyPricesService = usersCurrencyPricesService;
    }

    @Override
    public void updatePrices() {
        for (CurrencyPrice currencyPrice : currencyPricesService.getCurrencyPrices()) {
            int currencyId = currencyPrice.getId();

            JSONObject json = JsonReader.readJsonFromUrl(mainURL + currencyId);
            if (json != null) {
                double currentPrice = json.getDouble("price_usd");
                currencyPrice.setPrice(currentPrice);
                currencyPricesService.saveCurrencyPrice(currencyPrice);
                LOGGER.info("Updated price: " + currencyPrice);
            }
        }
    }

    @Override
    public void checkPriceChangesForUsers() {
        for (UsersCurrencyPrice usersCurrencyPrice : usersCurrencyPricesService.findAll()) {

            CurrencyPrice currencyPrice = currencyPricesService.getCurrencyPriceById(usersCurrencyPrice.getCurrencyPrice().getId());
            double userStartPrice = usersCurrencyPrice.getPrice();
            double currentPrice = currencyPrice.getPrice();
            double percent = changesInPercent(userStartPrice, currentPrice);

            if (Math.abs(percent) >= 1)
                LOGGER.warn(String.format("%s|%s|%s|%.2f",
                        currencyPrice.getSymbol(), currencyPrice.getName(),
                        usersCurrencyPrice.getUser().getName(),
                        percent));
        }
    }

    public double changesInPercent(double firstPrice, double secondPrice) {
        return secondPrice / firstPrice * 100 - 100;
    }
}
