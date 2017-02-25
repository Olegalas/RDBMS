package com.dex.data.controller;

import com.dex.data.manager.UserManager;
import com.dex.data.model.Notification;
import com.dex.data.model.User;

/**
 * Created by dexter on 09.01.17.
 */
public class Controller {

    private UserManager manager;

    public User login(String login, String pass){

        User user =  manager.login(login, pass);
        System.out.println("User entered : " + user);

        return user;
    }

    public User registration(String login, String pass){

        User user = manager.createUser(login, pass);
        System.out.println("User was successfully created : " + user);

        return user;
    }

    public User changePass(String login, String oldPass, String newPass){

        User user = manager.changePass(login, oldPass, newPass);
        System.out.println("Password was successfully changed : " + user);

        return user;
    }

    public User deRegistration(String login, String pass){

        User user = manager.removeUser(login, pass);
        System.out.println("User was successfully removed : " + user);

        return user;
    }

    public User sendMessage(String login, String message, Notification.Type type) {

        User user = manager.sendMessage(login, message, type);
        System.out.println("Message was successfully sent. Message : " + user.getNotifications().stream().filter(e -> e.getMessage().equals(message)).findAny().orElse(null));
        System.out.println("User : " + user);

        return user;
    }
}
