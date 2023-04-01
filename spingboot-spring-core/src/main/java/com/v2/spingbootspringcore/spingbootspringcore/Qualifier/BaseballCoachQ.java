package com.v2.spingbootspringcore.spingbootspringcore.Qualifier;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoachQ implements CoachQ{
    @Override
    public String getDailyWorkoutQ() {
        return "practicing baseball for baseball";
    }
}
