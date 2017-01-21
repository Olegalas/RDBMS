package com.dex.data.dao;

import com.dex.data.model.User;
import com.dex.data.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by dexter on 21.01.17.
 */
public class HibernateUserDao {

    private Session session = HibernateUtil.getSessionFactory().openSession();

    @SuppressWarnings("unchecked")
    public List<User> selectAllUsers(String login){
        String hql = "FROM User U WHERE U.login = :login ";
        return session.createQuery(hql).setParameter("login", login).list();
    }

    @SuppressWarnings("unchecked")
    public List<User> selectAllUsers2(String login){
        return session.createCriteria(User.class).add(Restrictions.eq("login", login)).list();
    }




}
