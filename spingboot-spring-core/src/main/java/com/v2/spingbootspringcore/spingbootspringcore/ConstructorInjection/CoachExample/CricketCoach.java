package com.v2.spingbootspringcore.spingbootspringcore.ConstructorInjection.CoachExample;

import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements  Coach{

    @Override
    public String getDailyWorkOut() {
            return "Practice fast bowling for 15 minutes.";
    }
}
