package com.v2.spingbootspringcore.spingbootspringcore.Qualifier;

import com.v2.spingbootspringcore.spingbootspringcore.ConstructorInjection.CoachExample.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Lazy
public class QualifierController    {
    private CoachQ coachQ;
    @Autowired
    public QualifierController(CoachQ cq){
        System.out.println("Qualifier controller constructor is called");
        this.coachQ=cq;
    }
//    public QualifierController(@Qualifier("cricketCoachQ") CoachQ cq){
//        this.coachQ=cq;
//    }
    @GetMapping("/dailyworkoutQ")
    public String getDailyWorkoutQ(){
        return coachQ.getDailyWorkoutQ();
    }

}
