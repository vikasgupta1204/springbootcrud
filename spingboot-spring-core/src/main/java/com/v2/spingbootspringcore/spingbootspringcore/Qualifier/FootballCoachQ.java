package com.v2.spingbootspringcore.spingbootspringcore.Qualifier;

import com.v2.spingbootspringcore.spingbootspringcore.SetterInjection.CoachExample.CoachSetter;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class FootballCoachQ implements CoachQ {
    public FootballCoachQ(){
        System.out.println("Football coach constructor is called");
    }
    @Override
    public String getDailyWorkoutQ() {
        return "practicing football for 15 minutes";
    }
}
