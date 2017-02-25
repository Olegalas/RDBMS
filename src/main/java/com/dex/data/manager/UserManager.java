package com.dex.data.manager;

import com.dex.data.dao.UserDaoI;
import com.dex.data.model.Notification;
import com.dex.data.model.User;

/**
 * Created by dexter on 09.01.17.
 */
public class UserManager {

    private UserDaoI userDao;

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

    public User sendMessage(String login, String message, Notification.Type type) {

        User user = userDao.getUser(login);
        if(user == null){
            user = new User(-1 , "not found", "not found");
            return user;
        }

        Notification notification = new Notification();
        notification.setType(type);
        notification.setMessage(message);
        notification.setUser(user);
        notification.setUserId(user.id);

        user.getNotifications().add(notification);

        userDao.updateUser(user);

        return user;
    }
}
