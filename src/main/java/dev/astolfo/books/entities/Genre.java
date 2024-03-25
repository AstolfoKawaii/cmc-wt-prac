package dev.astolfo.books.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "genres")
public class Genre {
//    id serial primary key,
//    genre varchar(64) not null

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "genre", nullable = false, length = 64)
    private String genre;

    @ManyToMany(mappedBy = "genres")
    private Set<Book> books;
}
