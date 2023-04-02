package com.v2.spingbootspringcore.spingbootspringcore.Beans.BeanLifecycleMethods;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MySqlDbbl implements Databasebl {
    @Override
    public void connect() {
        System.out.println("Mysql is connected");
    }

    //define our init method
    @PostConstruct
    public void doMyStartUpStuff(){
        System.out.println(
                "In doMyStartUpStuff(): "+getClass().getSimpleName());

    }

    @PreDestroy
    public void doMyCleanUpStuff(){
        System.out.println( "In doMyCleanUpStuff(): "+getClass().getSimpleName());
    }
}
