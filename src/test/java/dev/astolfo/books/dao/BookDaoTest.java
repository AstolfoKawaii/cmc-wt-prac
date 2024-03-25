package dev.astolfo.books.dao;

import dev.astolfo.books.entities.Book;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class BookDaoTest {
    private SessionFactory sessionFactory;
    private Transaction trans;
    private BookDao dao;

    @BeforeEach
    void setUp() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        trans = sessionFactory.getCurrentSession().beginTransaction();
        dao = new BookDao(sessionFactory);
    }

    @AfterEach
    void tearDown() {
        trans.rollback();
        sessionFactory.close();
    }

    @Test
    void persist() {
        var numberOfBooks = dao.listAll().size();

        var newBook = new Book();
        newBook.setTitle("new title");
        newBook.setDescription("description");
        newBook.setPriceCents(1);
        newBook.setQuantity(1);
        newBook.setAdditionalInfo(new HashMap<>());
        newBook.setSeller(new UserDao(sessionFactory).findOne(1));
        newBook.setDeleted(false);

        dao.persist(newBook);

        assertEquals(numberOfBooks + 1, dao.listAll().size());
    }

    @Test
    void update() {
        var book = dao.findOne(1);
        assertNotEquals(book.getTitle(), "test title");
        sessionFactory.getCurrentSession().evict(book);
        book.setTitle("test title");
        dao.update(book);
        book = dao.findOne(1);
        assertEquals(book.getTitle(), "test title");
    }

    @Test
    void delete() {
        var book = dao.findOne(1);
        assertNotNull(book);
        dao.delete(book);
        book = dao.findOne(1);
        assertNull(book);
    }

    @Test
    void searchBooks() {
        var books = dao.searchBooks("House");
        assertEquals(books.size(), 1);
        assertEquals(books.getFirst().getTitle(), "House of Flame and Shadow");
    }
}