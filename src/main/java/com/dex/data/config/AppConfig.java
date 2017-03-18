package com.dex.data.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by dexter on 08.03.17.
 */
@SpringBootApplication(scanBasePackages = {"com.dex.data"}, exclude = HibernateJpaAutoConfiguration.class)
@EnableAspectJAutoProxy
public class AppConfig {

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class);
    }

}
