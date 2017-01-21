package com.dex.data.controller;

import com.dex.data.manager.UserManager;
import com.dex.data.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dexter on 09.01.17.
 */
public class Controller {

    private UserManager manager;

    private static final Controller instance = new Controller();

    private Controller() {
        manager = new UserManager();
    }

    public static Controller getInstance(){
        return instance;
    }

    public List<User> getAllUsers(String login){
        return manager.getAllUsers(login);
    }

}
