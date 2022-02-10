package com.example.cryptocurrencywatcher.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "currency_prices")
public class CurrencyPrice {
    private long id;
    private String symbol;
    private String name;
    private double price;

    private Set<UsersCurrencyPrice> usersCurrencyPrice = new HashSet<>();

    public CurrencyPrice() {
    }

    public CurrencyPrice(String symbol, String name, Double price) {
        this.symbol = symbol;
        this.name = name;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_price")
    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @OneToMany(mappedBy = "currencyPrice")
    public Set<UsersCurrencyPrice> getUsersCurrencyPrice() {
        return usersCurrencyPrice;
    }

    public void setUsersCurrencyPrice(Set<UsersCurrencyPrice> usersCurrencyPrice) {
        this.usersCurrencyPrice = usersCurrencyPrice;
    }

    public void addUsersCurrencyPrices(UsersCurrencyPrice usersCurrencyPrice) {
        this.usersCurrencyPrice.add(usersCurrencyPrice);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrencyPrice that = (CurrencyPrice) o;
        return id == that.id && Double.compare(that.price, price) == 0 && Objects.equals(symbol, that.symbol) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, symbol, name, price);
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
