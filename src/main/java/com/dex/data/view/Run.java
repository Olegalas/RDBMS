package com.dex.data.view;

import com.dex.data.context.Context;
import com.dex.data.controller.Controller;
import com.dex.data.model.Notification;

/**
 * Created by dexter on 09.01.17.
 */
public class Run {

    public static void main(String[] args) {

//        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
//        UserDao userDao = (UserDao) context.getBean("userDao");

        Controller controller = Context.getBean(Controller.class);

        controller.sendMessage("ALEX", "Some message", Notification.Type.INFO);

    }

}
