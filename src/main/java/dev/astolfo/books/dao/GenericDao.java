package dev.astolfo.books.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

// from https://www.baeldung.com/persistence-layer-with-spring-and-hibernate
public abstract class GenericDao<T> {
    private final Class<T> tClass;

    protected SessionFactory sessionFactory;

    protected GenericDao(SessionFactory sessionFactory, Class<T> tClass) {
        this.tClass = tClass;
        this.sessionFactory = sessionFactory;
    }

    public List<T> listAll() {
        var session = getCurrentSession();
        var builder = session.getCriteriaBuilder();
        var criteria = builder.createQuery(tClass);
        criteria.from(tClass);
        return session.createQuery(criteria).getResultList();
    }

    public T findOne(final long id) {
        return (T) getCurrentSession().get(tClass, id);
    }

    public void persist(T entity) {
        getCurrentSession().persist(entity);
    }

    public void update(final T entity) {
        getCurrentSession().merge(entity);
    }

    public void delete(final T entity) {
        getCurrentSession().remove(entity);
    }

    public void deleteAll() {
        listAll().forEach(this::delete);
    }

    public void deleteById(final long entityId) {
        final T entity = findOne(entityId);
        delete(entity);
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}