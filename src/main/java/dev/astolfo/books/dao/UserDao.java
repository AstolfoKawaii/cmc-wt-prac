package dev.astolfo.books.dao;

import dev.astolfo.books.entities.User;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionFactory;

public class UserDao extends GenericDao<User> {
    public UserDao(SessionFactory builder) {
        super(builder, User.class);
    }

    public User findByEmail(String email) {
        var session = getCurrentSession();
        var builder = session.getCriteriaBuilder();
        var criteria = builder.createQuery(User.class);
        var root = criteria.from(User.class);
        criteria.where(builder.equal(root.get("email"), email));
        return session.createQuery(criteria).getSingleResultOrNull();
    }
}
