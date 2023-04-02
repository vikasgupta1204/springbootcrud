package com.v2.spingbootspringcore.spingbootspringcore.Beans.BeanConfig.Config;

import com.v2.spingbootspringcore.spingbootspringcore.Beans.BeanConfig.CricketPlayer;
import com.v2.spingbootspringcore.spingbootspringcore.Beans.BeanConfig.FootballPlayer;
import com.v2.spingbootspringcore.spingbootspringcore.Beans.BeanConfig.Player;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlayerConfig
{
    @Bean("cricketer")
    public Player cricketPlayer(){
        return new CricketPlayer();
    }
    @Bean
    public Player footballPlayer(){
        return new FootballPlayer();
    }
}
