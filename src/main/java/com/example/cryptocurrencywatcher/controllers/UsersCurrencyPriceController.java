package com.example.cryptocurrencywatcher.controllers;

import com.example.cryptocurrencywatcher.services.UsersCurrencyPricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usersCurrencyPrice")
public class UsersCurrencyPriceController {
    private final UsersCurrencyPricesService usersCurrencyPricesService;

    @Autowired
    public UsersCurrencyPriceController(UsersCurrencyPricesService usersCurrencyPricesService) {
        this.usersCurrencyPricesService = usersCurrencyPricesService;
    }

    @PostMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        long userId = usersCurrencyPricesService.findById(id).getUser().getId();
        usersCurrencyPricesService.delete(id);
        return "redirect:/users/" + userId;
    }
}
