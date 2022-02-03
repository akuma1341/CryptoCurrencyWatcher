package com.example.cryptocurrencywatcher.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @OneToMany(mappedBy = "user")
    private Set<UsersCurrencyPrice> usersCurrencyPrices;

    public User(Integer id, String name, Set<UsersCurrencyPrice> usersCurrencyPrices) {
        this.id = id;
        this.name = name;
        this.usersCurrencyPrices = usersCurrencyPrices;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UsersCurrencyPrice> getUsersCurrencyPrices() {
        return usersCurrencyPrices;
    }

    public void setUsersCurrencyPrices(Set<UsersCurrencyPrice> usersCurrencyPrices) {
        this.usersCurrencyPrices = usersCurrencyPrices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(usersCurrencyPrices, user.usersCurrencyPrices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, usersCurrencyPrices);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
