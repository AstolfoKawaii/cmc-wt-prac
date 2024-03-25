package dev.astolfo.books.entities;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "users")
public class User {
//    id serial primary key,
//    full_name varchar(64) not null,
//    email varchar(64) unique not null,
//    phone varchar(64) not null,
//    mailing_address text not null,
//    passwd_hash varchar(64) not null,
//    deleted bool not null default false

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "full_name", nullable = false, length = 64)
    private String fullName;

    @Column(name = "email", unique = true, nullable = false, length = 64)
    private String email;

    @Column(name = "phone", nullable = false, length = 64)
    private String phone;

    @Column(name = "mailing_address", nullable = false, length = -1)
    private String mailingAddress;

    @Column(name = "passwd_hash", nullable = false, length = 64)
    private String passwordHash;

    @Column(name = "deleted", nullable = false)
    private boolean deleted;

    @OneToMany(mappedBy = "buyer")
    private Set<Order> placedOrders;

    @OneToMany(mappedBy = "seller")
    private Set<Book> sellingBooks;
}
