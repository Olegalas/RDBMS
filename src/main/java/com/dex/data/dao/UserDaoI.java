package com.dex.data.dao;

import com.dex.data.model.User;

import java.util.List;

/**
 * Created by dexter on 28.01.17.
 */
public interface UserDaoI {

    User getUser(String login);
    List<User> getAllUsers();
    void updateUser(User user);
    void saveUser(User user);
    void removeUser(User user);

}
