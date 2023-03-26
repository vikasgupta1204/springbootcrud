package com.rest.springboot.demo.myspringbootapp.Controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstRestController {

    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;
    @GetMapping("/")
    public String sayHello(){
        System.out.println(coachName+" "+teamName);
        return "Hello World!";
    }

}
