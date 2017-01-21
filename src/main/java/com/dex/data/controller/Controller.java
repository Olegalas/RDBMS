package com.dex.data.controller;

import com.dex.data.manager.UserManager;

import java.sql.SQLException;

/**
 * Created by dexter on 09.01.17.
 */
public class Controller {

    private UserManager manager;

    private static final Controller instance = new Controller();

    private Controller() {
        try {
            manager = new UserManager();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static Controller getInstance(){
        return instance;
    }

    public void showAllUsers(){
        System.out.println(manager.getAllUsers());
    }

}
