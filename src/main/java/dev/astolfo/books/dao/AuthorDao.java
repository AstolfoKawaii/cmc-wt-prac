package dev.astolfo.books.dao;

import dev.astolfo.books.entities.Author;
import dev.astolfo.books.entities.User;
import org.hibernate.SessionFactory;

public class AuthorDao extends GenericDao<Author>{
    public AuthorDao(SessionFactory builder) {
        super(builder, Author.class);
    }
}
