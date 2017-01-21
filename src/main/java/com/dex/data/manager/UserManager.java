package com.dex.data.manager;

import com.dex.data.dao.UserDao;
import com.dex.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by dexter on 09.01.17.
 */
public class UserManager {

    private UserDao userDao;


    public UserManager() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        userDao = new UserDao();
    }

    public List<User> getAllUsers(){
        return userDao.selectAllUsers();
    }

}
