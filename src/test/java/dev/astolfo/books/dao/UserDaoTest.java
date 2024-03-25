package dev.astolfo.books.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    private SessionFactory sessionFactory;
    private Transaction trans;
    private UserDao dao;

    @BeforeEach
    void setUp() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        trans = sessionFactory.getCurrentSession().beginTransaction();
        dao = new UserDao(sessionFactory);
    }

    @AfterEach
    void tearDown() {
        trans.rollback();
        sessionFactory.close();
    }

    @Test
    void findByEmail() {
        var user = dao.findByEmail("anna@abramova.dev");
        assertEquals(user.getEmail(), "anna@abramova.dev");
    }
}