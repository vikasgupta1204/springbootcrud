package com.v1.actuator.actuatordemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
@GetMapping("/")
    public String hello(){
    return "hello";
}
}
