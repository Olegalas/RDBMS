package com.dex.data.manager;

import com.dex.data.dao.HibernateUserDao;
import com.dex.data.dao.UserDao;
import com.dex.data.dao.UserDaoI;
import com.dex.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dexter on 09.01.17.
 */
public class UserManager {

    private UserDaoI userDao;


    public UserManager(){
        userDao = new HibernateUserDao();
    }


    public User createUser(String login, String pass) {
        User user = new User();
        user.pass = pass;
        user.login = login;

        userDao.saveUser(user);

        return user;
    }


    public User login(String login, String pass) {

        User user = userDao.getUser(login);
        if(user != null && user.pass.equals(pass)){
            return user;
        }

        throw new RuntimeException("wrong login or password");
    }

    public User changePass(String login, String oldPass, String newPass) {

        User user = userDao.getUser(login);
        if(user != null && user.pass.equals(oldPass)){

            user.pass = newPass;
            userDao.updateUser(user);

            return user;
        }

        throw new RuntimeException("wrong login or password");
    }


    public User removeUser(String login, String pass) {

        User user = userDao.getUser(login);
        if(user != null && user.pass.equals(pass)){

            userDao.removeUser(user);

            return user;
        }

        throw new RuntimeException("wrong login or password");
    }

}
