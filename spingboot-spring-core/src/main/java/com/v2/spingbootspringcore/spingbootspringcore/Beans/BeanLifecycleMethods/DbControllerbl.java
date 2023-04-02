package com.v2.spingbootspringcore.spingbootspringcore.Beans.BeanLifecycleMethods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DbControllerbl
{
    private Databasebl db;
    @Autowired
    public DbControllerbl(Databasebl db){
        this.db=db;

    }

    @GetMapping("/connectInit")
    public String connect(){
        db.connect();

        return db.getClass().getName()+" connect method is called";
    }
}
