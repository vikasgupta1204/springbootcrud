package com.spring.cm.contactmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//to specify the configuration file
@Configuration
@EnableWebSecurity
public class MyConfig  extends WebSecurityConfigurerAdapter {
    
    @Bean
    public UserDetailsService getUserDetailService(){
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(getUserDetailService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }  
    
    ///configure method
    public void configure(AuthenticationManagerBuilder auth){
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*Methods to configure the behavior of login page spring security */
        http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
        .antMatchers("/user/**").hasRole("USER").antMatchers("/**").permitAll().and().
        formLogin().loginPage("/signin").loginProcessingUrl("/dologin").
        defaultSuccessUrl("/user/index").
        failureUrl("/login-fail").and().csrf().disable();
        super.configure(http);
    }
    
}