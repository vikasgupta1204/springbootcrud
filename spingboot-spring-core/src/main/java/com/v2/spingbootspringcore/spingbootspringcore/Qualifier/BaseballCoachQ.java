package com.v2.spingbootspringcore.spingbootspringcore.Qualifier;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component

@Lazy
public class BaseballCoachQ implements CoachQ{
    public BaseballCoachQ(){
        System.out.println("Baseballcoach constructor called!!");
    }
    @Override
    public String getDailyWorkoutQ() {
        return "practicing baseball for baseball";
    }
}
