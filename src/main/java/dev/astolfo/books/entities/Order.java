package dev.astolfo.books.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@Entity
@Table(name = "orders")
public class Order {
//    id serial primary key,
//    book_id int not null references books,
//    buyer_id int not null references users,
//    mailing_address text not null,
//    total_actual_price money not null,
//    quantity int not null,
//    placed_at timestamp not null,
//    status order_status not null,
//    updated_at timestamp not null
    public enum Status {
        NEW,
        APPROVED,
        DELIVERED;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name="book_id", nullable=false)
    private Book book;

    @ManyToOne
    @JoinColumn(name="buyer_id", nullable=false)
    private User buyer;

    @Column(name = "mailing_address", nullable = false, length = -1)
    private String mailingAddress;

    @Column(name = "total_actual_price", nullable = false)
    private int totalActualPriceCents;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "placed_at", nullable = false)
    private Timestamp placedAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;
}
