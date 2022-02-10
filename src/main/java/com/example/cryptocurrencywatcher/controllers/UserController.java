package com.example.cryptocurrencywatcher.controllers;

import com.example.cryptocurrencywatcher.entities.User;
import com.example.cryptocurrencywatcher.entities.UsersCurrencyPrice;
import com.example.cryptocurrencywatcher.services.CurrencyPricesService;
import com.example.cryptocurrencywatcher.services.UserService;
import com.example.cryptocurrencywatcher.services.UsersCurrencyPricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final CurrencyPricesService currencyPricesService;
    private final UsersCurrencyPricesService usersCurrencyPricesService;

    @Autowired
    public UserController(UserService userService, CurrencyPricesService currencyPricesService, UsersCurrencyPricesService usersCurrencyPricesService) {
        this.userService = userService;
        this.currencyPricesService = currencyPricesService;
        this.usersCurrencyPricesService = usersCurrencyPricesService;
    }

    @GetMapping
    public String allUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String userById(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        UsersCurrencyPrice usersCurrencyPrice = new UsersCurrencyPrice();
        model.addAttribute("usersCurrencyPrice", usersCurrencyPrice);
        model.addAttribute("prices", currencyPricesService.getCurrencyPrices());
        return "user";
    }

    @PostMapping("/{id}")
    public String addCurrencyToUser(@PathVariable("id") long id, @ModelAttribute("usersCurrencyPrice") UsersCurrencyPrice usersCurrencyPrice) {
        UsersCurrencyPrice price = new UsersCurrencyPrice();

        long currencyId = usersCurrencyPrice.getCurrencyPrice().getId();
        double currentCurrencyPrice = currencyPricesService.getCurrencyPriceById(currencyId).getPrice();

        price.setUser(userService.getUserById(id));
        price.setCurrencyPrice(usersCurrencyPrice.getCurrencyPrice());
        price.setPrice(currentCurrencyPrice);
        usersCurrencyPricesService.save(price);
        return "redirect:/users/" + id;
    }

    @GetMapping("/createUser")
    public String createUser(@ModelAttribute("user") User user) {
        return "createUser";
    }

    @PostMapping("/createUser")
    public String acceptUserCreation(@ModelAttribute User user) {
        User createdUser = userService.saveUser(user);
        return "redirect:/users/" + createdUser.getId();
    }
}
