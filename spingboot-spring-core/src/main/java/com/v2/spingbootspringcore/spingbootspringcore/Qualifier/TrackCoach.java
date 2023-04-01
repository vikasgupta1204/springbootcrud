package com.v2.spingbootspringcore.spingbootspringcore.Qualifier;

public class TrackCoach implements CoachQ{
    @Override
    public String getDailyWorkoutQ() {
        return "Track coach for 15 minutes";
    }
}
