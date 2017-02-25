package com.dex.data.dao;

import com.dex.data.model.User;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by dexter on 21.01.17.
 */
public class HibernateUserDao implements UserDaoI{

    private Session session;

    public User getUser(String login) {
        String hql = "FROM User U WHERE U.login = :login ";
        return (User) session.createQuery(hql).setParameter("login", login).getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        String hql = "FROM User U WHERE U.login = :login ";
        return session.createQuery(hql).list();
    }

    public void updateUser(User user) {
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }

    public void saveUser(User user) {
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
    }

    public void removeUser(User user) {
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
    }

}
