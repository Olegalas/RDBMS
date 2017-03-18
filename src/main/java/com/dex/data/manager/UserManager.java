package com.dex.data.manager;

import com.dex.data.dao.UserDaoI;
import com.dex.data.dto.UserDTO;
import com.dex.data.model.Notification;
import com.dex.data.model.User;
import com.dex.data.transformers.UserTransformer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * Created by dexter on 09.01.17.
 */
@Service
@Transactional
public class UserManager {

    @Resource(name = "hibernateUserDao")
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

    public UserDTO sendMessage(String login, String message, Notification.Type type) {
        Optional<User> user = Optional.ofNullable(userDao.getUser(login));
        user.ifPresent(u -> {
            Notification notification = new Notification();
            notification.setType(type);
            notification.setMessage(message);
            notification.setUser(u);
            notification.setUserId(u.id);

            u.getNotifications().add(notification);

            userDao.updateUser(u);
        });

        return user.map(UserTransformer.toDTO).orElseGet(UserDTO::new);
    }
}
