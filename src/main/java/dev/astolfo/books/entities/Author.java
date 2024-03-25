package dev.astolfo.books.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "authors")
public class Author {
//    id serial primary key,
//    full_name varchar(64) not null

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "full_name", nullable = false, length = 64)
    private String fullName;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;
}
