package com.v2.spingbootspringcore.spingbootspringcore.Qualifier;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TrackCoach implements CoachQ{
    @Override
    public String getDailyWorkoutQ() {
        return "Track coach for 15 minutes";
    }
}
