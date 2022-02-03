package com.example.cryptocurrencywatcher.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users_currency_prices")
public class UsersCurrencyPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "id_price")
    private CurrencyPrice currencyPrice;

    public UsersCurrencyPrice(Integer id, Double price, User user, CurrencyPrice currencyPrice) {
        this.id = id;
        this.price = price;
        this.user = user;
        this.currencyPrice = currencyPrice;
    }

    public UsersCurrencyPrice() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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
        UsersCurrencyPrice that = (UsersCurrencyPrice) o;
        return Objects.equals(id, that.id) && Objects.equals(price, that.price) && Objects.equals(user, that.user) && Objects.equals(currencyPrice, that.currencyPrice);
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
