package com.dex.data.view;

import com.dex.data.dao.UserDao;
import com.dex.data.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by dexter on 09.01.17.
 */
public class Run {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");

        List<User> users = userDao.selectAllUsers();

        System.out.println(users);
    }

}
