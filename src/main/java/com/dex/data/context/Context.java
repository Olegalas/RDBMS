package com.dex.data.context;

import com.dex.data.controller.Controller;
import com.dex.data.dao.HibernateUserDao;
import com.dex.data.dao.UserDaoI;
import com.dex.data.manager.UserManager;
import com.dex.data.util.HibernateUtil;
import org.hibernate.Session;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dexter on 25.02.17.
 */
public class Context {

    private static final Map<Class, Object> context = new HashMap<>();

    static {
        context.put(Controller.class, new Controller());
        context.put(UserManager.class, new UserManager());
        context.put(UserDaoI.class, new HibernateUserDao());
        context.put(Session.class, HibernateUtil.getSessionFactory().openSession());
    }

    @SuppressWarnings("unchecked")
    public static<T> T getBean(Class<T> clazz){

        T instance = (T) context.get(clazz);
        if(clazz == Session.class) return instance;

        for(Field f : instance.getClass().getDeclaredFields()){
            try {
                f.setAccessible(true);
                f.set(instance, getBean(f.getType()));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
}
