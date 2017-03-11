package com.dex.data.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by dexter on 08.03.17.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(value = {"com.dex.data"})
public class AppConfig {
}
