package ru.kpfu.itis.kulsidv.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.kulsidv.entity.User;

import java.util.List;

@Component
public class UserRepositoryHiber {

    private final SessionFactory sessionFactory;

    public UserRepositoryHiber(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<User> findAll() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException e) {
            session = sessionFactory.openSession();
        }
        return session.createQuery("from User").list();
    }

    public User saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
            session.persist(user); // Для новых объектов
            // или session.merge(user); // Для обновления существующих
            session.getTransaction().commit();
            return user;
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            throw new RuntimeException("Failed to save user", e);
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }
}