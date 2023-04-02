package com.v2.spingbootspringcore.spingbootspringcore.Beans.BeanConfig;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
Player player;

public PlayerController(@Qualifier("footballPlayer") Player player){
    this.player=player;
}

@GetMapping("/doPractice")
public String doPractice(){
    return player.doPractice();
}
}
