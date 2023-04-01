package com.v2.spingbootspringcore.spingbootspringcore.Beans.SingletonBeanScope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DbController
{
    private Database db;
    private  Database db1;
    @Autowired
    public DbController(Database db,Database db1){
        this.db=db;
        this.db1=db1;
    }

    @GetMapping("/connect")
    public String connect(){
        db.connect();
        System.out.println(db==db1);
        return db.getClass().getName()+" connect method is called";
    }
}
