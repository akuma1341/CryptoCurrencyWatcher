package com.example.cryptocurrencywatcher.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "currency_prices")
public class CurrencyPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String symbol;
    private String name;
    private Double price;

    @OneToMany(mappedBy = "currencyPrice")
    private Set<UsersCurrencyPrice> usersCurrencyPrice;

    public CurrencyPrice(Integer id, String symbol, String name, Double price, Set<UsersCurrencyPrice> usersCurrencyPrice) {
        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.price = price;
        this.usersCurrencyPrice = usersCurrencyPrice;
    }

    public CurrencyPrice() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<UsersCurrencyPrice> getUsersCurrencyPrice() {
        return usersCurrencyPrice;
    }

    public void setUsersCurrencyPrice(Set<UsersCurrencyPrice> usersCurrencyPrice) {
        this.usersCurrencyPrice = usersCurrencyPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyPrice that = (CurrencyPrice) o;
        return Objects.equals(id, that.id) && Objects.equals(symbol, that.symbol) && Objects.equals(name, that.name) && Objects.equals(price, that.price) && Objects.equals(usersCurrencyPrice, that.usersCurrencyPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, symbol, name, price, usersCurrencyPrice);
    }

    @Override
    public String toString() {
        return "CurrencyPrice{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
