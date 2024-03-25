package dev.astolfo.books.dao;

import dev.astolfo.books.entities.Author;
import dev.astolfo.books.entities.Genre;
import org.hibernate.SessionFactory;

public class GenreDao extends GenericDao<Genre> {
    public GenreDao(SessionFactory builder) {
        super(builder, Genre.class);
    }
}
