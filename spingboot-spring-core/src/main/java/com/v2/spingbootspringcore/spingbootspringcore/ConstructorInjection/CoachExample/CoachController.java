package com.v2.spingbootspringcore.spingbootspringcore.ConstructorInjection.CoachExample;

import com.v2.spingbootspringcore.outside.TestClass;
import com.v2.spingbootspringcore.outside.TestInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachController {
//define a private field for dependency
    private Coach myCoach;
    private TestInterface testInterface;
    @Autowired
    public CoachController(Coach c,TestInterface testInterface){

        this.myCoach=c;
        this.testInterface=testInterface;
    }

    @GetMapping("/dailyWorkOut")
    public String getDailyWorkOut(){
        return myCoach.getDailyWorkOut();
    }

    @GetMapping("/outside")
    public String getOutSideCheck(){
        return testInterface.check();
    }
}
