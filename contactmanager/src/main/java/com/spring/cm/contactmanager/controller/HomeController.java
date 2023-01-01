package com.spring.cm.contactmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.cm.contactmanager.dao.UserRepository;
import com.spring.cm.contactmanager.entities.Contact;
import com.spring.cm.contactmanager.entities.User;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        User user=new User();
        user.setName("Vikas Gupta");
        user.setEmail("vikas@gmail.com");
        user.setPassword("abccdddd");
        user.setAbout("about111111111");
        Contact contact=new Contact();
       // contact.setEmail("vikas@gmail.com");
        user.getContacts().add(contact);

        userRepository.save(user);
        System.out.println("user saved successfully");
        return "Working";
    }
}