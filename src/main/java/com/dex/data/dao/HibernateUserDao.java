package com.dex.data.dao;

import com.dex.data.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dexter on 21.01.17.
 */
@Repository
public class HibernateUserDao implements UserDaoI{

    @Autowired
    private SessionFactory sessionFactory;

    public User getUser(String login) {
        String hql = "FROM User U WHERE U.login = :login ";
        return (User) sessionFactory.getCurrentSession().createQuery(hql).setParameter("login", login).getSingleResult();
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        String hql = "FROM User U WHERE U.login = :login ";
        return sessionFactory.getCurrentSession().createQuery(hql).list();
    }

    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    public void saveUser(User user) {
        sessionFactory.getCurrentSession().persist(user);
    }

    public void removeUser(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

}
