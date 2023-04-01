package com.v2.spingbootspringcore.spingbootspringcore.Beans.SingletonBeanScope;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MySqlDb implements Database{
    @Override
    public void connect() {
        System.out.println("Mysql is connected");
    }
}
