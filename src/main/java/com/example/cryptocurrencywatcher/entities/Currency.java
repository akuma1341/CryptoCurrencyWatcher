package com.example.cryptocurrencywatcher.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "currency_type")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String symbol;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return Objects.equals(id, currency.id) && Objects.equals(symbol, currency.symbol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, symbol);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}
