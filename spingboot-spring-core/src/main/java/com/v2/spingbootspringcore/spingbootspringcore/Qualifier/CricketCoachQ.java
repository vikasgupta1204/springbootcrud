package com.v2.spingbootspringcore.spingbootspringcore.Qualifier;

import org.springframework.stereotype.Component;

@Component
public class CricketCoachQ implements CoachQ{
    @Override
    public String getDailyWorkoutQ() {
        return "practicing cricket for 15 minutes";
    }
}
