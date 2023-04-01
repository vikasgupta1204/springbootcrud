package com.v2.spingbootspringcore.spingbootspringcore.Beans.SingletonBeanScope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Primary
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MySqlDb implements Database{
    @Override
    public void connect() {
        System.out.println("Mysql is connected");
    }
}
