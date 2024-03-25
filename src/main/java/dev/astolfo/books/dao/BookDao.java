package dev.astolfo.books.dao;

import dev.astolfo.books.entities.Book;
import org.hibernate.SessionFactory;

import java.util.List;

public class BookDao extends GenericDao<Book> {
    public BookDao(SessionFactory builder) {
        super(builder, Book.class);
    }

    public List<Book> searchBooks(String phrase) {
        return getCurrentSession()
                .createNativeQuery(
                        "select * from books b1_0 where to_tsvector('english', b1_0.title) @@ websearch_to_tsquery('english', :textQuery)", Book.class)
                .setParameter("textQuery", phrase).getResultList();

    }
}
