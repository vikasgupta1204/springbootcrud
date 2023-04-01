package com.v2.spingbootspringcore.spingbootspringcore.Qualifier;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Lazy
public class TrackCoach implements CoachQ{
    public TrackCoach(){
        System.out.println("Track coach constructor is called!!");
    }
    @Override
    public String getDailyWorkoutQ() {
        return "Track coach for 15 minutes";
    }
}
