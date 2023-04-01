package com.v2.spingbootspringcore.spingbootspringcore.Qualifier;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class CricketCoachQ implements CoachQ{

    public CricketCoachQ(){
        System.out.println("Cricket coach constructor is called!!");
    }
    @Override
    public String getDailyWorkoutQ() {
        return "practicing cricket for 15 minutes";
    }
}
