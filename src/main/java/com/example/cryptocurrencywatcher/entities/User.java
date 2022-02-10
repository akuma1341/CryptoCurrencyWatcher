package com.example.cryptocurrencywatcher.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    private long id;
    private String name;

    private Set<UsersCurrencyPrice> usersCurrencyPrice = new HashSet<>();

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<UsersCurrencyPrice> getUsersCurrencyPrice() {
        return usersCurrencyPrice;
    }

    public void setUsersCurrencyPrice(Set<UsersCurrencyPrice> usersCurrencyPrice) {
        this.usersCurrencyPrice = usersCurrencyPrice;
    }

    public void addUsersCurrencyPrice(UsersCurrencyPrice usersCurrencyPrice) {
        this.usersCurrencyPrice.add(usersCurrencyPrice);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
