package com.v2.spingbootspringcore.spingbootspringcore.SetterInjection.CoachExample;

import com.v2.spingbootspringcore.outside.TestInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoachSetterController {
//define a private field for dependency
    private CoachSetter myCoach;
    private TestInterface testInterface;
    @Autowired
    public void setCoach(CoachSetter c){
        this.myCoach=c;
    }

    @GetMapping("/dailyWorkOutSetter")
    public String getDailyWorkOut1(){
        return myCoach.getDailyWorkOut1();
    }


}
