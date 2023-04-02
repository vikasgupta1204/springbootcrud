package com.v2.spingbootspringcore.spingbootspringcore.Beans.BeanLifecycleMethods;

import org.springframework.stereotype.Component;

@Component
public class OracleDbbl implements Databasebl {
    @Override
    public void connect() {
        System.out.println("Oracle is connected");
    }
}
