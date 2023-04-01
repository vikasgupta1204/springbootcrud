package com.v2.spingbootspringcore.spingbootspringcore.Beans.SingletonBeanScope;

import org.springframework.stereotype.Component;

@Component
public class Oracle implements Database{
    @Override
    public void connect() {
        System.out.println("Oracle is connected");
    }
}
