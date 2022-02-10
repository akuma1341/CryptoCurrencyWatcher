package com.example.cryptocurrencywatcher;

import com.example.cryptocurrencywatcher.entities.User;
import com.example.cryptocurrencywatcher.entities.UsersCurrencyPrice;
import com.example.cryptocurrencywatcher.repositories.UserRepository;
import com.example.cryptocurrencywatcher.repositories.UsersCurrencyPricesRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Set;

@DataJpaTest
public class TestApp {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UsersCurrencyPricesRepository userPrices;

    @Test
    @DisplayName("проверка вывода данных")
    public void whenGetUser_pricesShouldBeShownToo() {
        User user = userRepository.getById(1L);
        Set<UsersCurrencyPrice> prices = user.getUsersCurrencyPrice();
        Assertions.assertEquals(2, prices.size());
        Assertions.assertEquals("User1", user.getName());
    }
}
