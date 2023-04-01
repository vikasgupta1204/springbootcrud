package com.v2.spingbootspringcore.spingbootspringcore.SetterInjection.CoachExample;

import org.springframework.stereotype.Component;

@Component
public class CricketCoachSetter implements CoachSetter {

    @Override
    public String getDailyWorkOut1() {
            return "Practice fast bowling for 15 minutes for setter injection";
    }
}
