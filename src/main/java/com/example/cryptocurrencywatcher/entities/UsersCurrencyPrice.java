package com.example.cryptocurrencywatcher.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users_currency_prices")
public class UsersCurrencyPrice {
    private long id;
    private double price;

    private User user;

    private CurrencyPrice currencyPrice;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @ManyToOne()
    @JoinColumn(name = "id_user")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne()
    @JoinColumn(name = "id_price")
    public CurrencyPrice getCurrencyPrice() {
        return currencyPrice;
    }

    public void setCurrencyPrice(CurrencyPrice currencyPrice) {
        this.currencyPrice = currencyPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersCurrencyPrice price1 = (UsersCurrencyPrice) o;
        return id == price1.id && Double.compare(price1.price, price) == 0 && Objects.equals(user, price1.user) && Objects.equals(currencyPrice, price1.currencyPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, user, currencyPrice);
    }

    @Override
    public String toString() {
        return "UsersCurrencyPrice{" +
                "id=" + id +
                ", price=" + price +
                ", user=" + user +
                ", currencyPrice=" + currencyPrice +
                '}';
    }
}
