package com.v2.spingbootspringcore.spingbootspringcore.Qualifier;

import com.v2.spingbootspringcore.spingbootspringcore.SetterInjection.CoachExample.CoachSetter;
import org.springframework.stereotype.Component;

@Component
public class FootballCoachQ implements CoachQ {
    @Override
    public String getDailyWorkoutQ() {
        return "practicing football for 15 minutes";
    }
}
