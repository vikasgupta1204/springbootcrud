package com.spring.cm.contactmanager.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.cm.contactmanager.dao.UserRepository;
import com.spring.cm.contactmanager.entities.User;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @RequestMapping("/index")
    public String dashboard(Model model,Principal principal){
        String userName=principal.getName();
        System.out.println("USERNAME: "+userName);
        User user=userRepository.getUserByUserName(userName);
        System.out.println("USER ->"+user);
        model.addAttribute("user", user);
        return "normal/user_dashboard";
    }
}