package dev.astolfo.books.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Map;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {
//    id serial primary key,
//    title varchar(64) not null,
//    description text not null,
//    price money not null,
//    quantity int not null,
//    seller_id int not null references users,
//    additional_info jsonb not null,
//    deleted bool not null default false

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "title", nullable = false, length = 64)
    private String title;

    @Column(name = "description", nullable = false, length = -1)
    private String description;

    @Column(name = "price", nullable = false)
    private int priceCents;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "additional_info", nullable = false)
    private Map<String, String> additionalInfo;

    @ManyToOne
    @JoinColumn(name="seller_id", nullable=false)
    private User seller;

    @Column(name = "deleted", nullable = false)
    private boolean deleted;

    @ManyToMany
    @JoinTable(
            name = "genre_book",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "genre_id") }
    )
    private Set<Genre> genres;

    @ManyToMany
    @JoinTable(
            name = "author_book",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "author_id") }
    )
    private Set<Author> authors;
}
