package com.dex.data.manager;

import com.dex.data.dao.HibernateUserDao;
import com.dex.data.dao.UserDao;
import com.dex.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dexter on 09.01.17.
 */
public class UserManager {

    private HibernateUserDao userDao;


    public UserManager(){
        userDao = new HibernateUserDao();
    }

    public List<User> getAllUsers(String login){
        return userDao.selectAllUsers2(login);
    }

}
