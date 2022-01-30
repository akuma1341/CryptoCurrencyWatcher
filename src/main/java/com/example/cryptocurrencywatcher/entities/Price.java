package com.example.cryptocurrencywatcher.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "prices")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double price;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_currency", referencedColumnName = "id")
    private Currency currency;

    @OneToOne(mappedBy = "price")
    private User user;

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

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price1 = (Price) o;
        return Objects.equals(id, price1.id) && Objects.equals(price, price1.price) && Objects.equals(currency, price1.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, currency);
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", price=" + price +
                ", currency='" + currency.getSymbol() + "'" +
                '}';
    }
}
