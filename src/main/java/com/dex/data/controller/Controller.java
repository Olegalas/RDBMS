package com.dex.data.controller;

import com.dex.data.dto.UserDTO;
import com.dex.data.manager.UserManager;
import com.dex.data.model.Notification;
import com.dex.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by dexter on 09.01.17.
 */
@RestController
public class Controller {

    @Autowired
    private UserManager manager;

    @RequestMapping("/login")
    public User login(String login, String pass){

        User user =  manager.login(login, pass);
        System.out.println("User entered : " + user);

        return user;
    }

    @RequestMapping("/registration")
    public User registration(String login, String pass){

        User user = manager.createUser(login, pass);
        System.out.println("User was successfully created : " + user);

        return user;
    }

    @RequestMapping("/changePass")
    public User changePass(String login, String oldPass, String newPass){

        User user = manager.changePass(login, oldPass, newPass);
        System.out.println("Password was successfully changed : " + user);

        return user;
    }

    @RequestMapping("/deRegistration")
    public User deRegistration(String login, String pass){

        User user = manager.removeUser(login, pass);
        System.out.println("User was successfully removed : " + user);

        return user;
    }

    @RequestMapping("/sendMessage")
    public UserDTO sendMessage(@RequestParam(name = "login") String login,
                               @RequestParam(name = "message") String message,
                               @RequestParam(name = "type") Notification.Type type) {

        return manager.sendMessage(login, message, type);
    }

}
