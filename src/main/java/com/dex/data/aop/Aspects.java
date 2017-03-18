package com.dex.data.aop;

import com.dex.data.dto.UserDTO;
import com.dex.data.model.Notification;
import com.dex.data.model.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by dexter on 11.03.17.
 */
@Aspect
@Component
public class Aspects {

//    @Before("pointCut() && args(login, message, type)")
//    public void before(String login, String message, Notification.Type type){
//        System.out.println("Preparation to send message");
//        System.out.println("login : " + login);
//        System.out.println("message : " + message);
//        System.out.println("type : " + type);
//    }
//
//    @AfterReturning(pointcut = "pointCut()", returning = "user")
//    public void returnUser(User user){
//        System.out.println("Message sent to : " + user);
//    }

    @Around(value = "pointCut()")
    public UserDTO around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        String methodName = proceedingJoinPoint.getSignature().getName();
        System.out.println("Started method : " + methodName);

        for(Object arg : proceedingJoinPoint.getArgs()){
            System.out.println("arg : " + arg);
        }

        UserDTO user = (UserDTO) proceedingJoinPoint.proceed();

        System.out.println("Message was sent to : " + user);

        return user;
    }

    @Pointcut(value = "execution(public * com.dex.data.controller.Controller.*(..))")
    private void pointCut(){}

}
