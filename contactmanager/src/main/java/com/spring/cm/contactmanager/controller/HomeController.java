package com.spring.cm.contactmanager.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.cm.contactmanager.dao.UserRepository;
import com.spring.cm.contactmanager.entities.Contact;
import com.spring.cm.contactmanager.entities.User;
import com.spring.cm.contactmanager.helper.Message;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("title", "Home-Smart Contact Manager");
        return "home";
    }

    @RequestMapping("/about")
    public String about(Model model){
        model.addAttribute("title", "About-Smart Contact Manager");

        return "about";
    }

    @RequestMapping("/signup")
    public String signup(Model model){
        model.addAttribute("title", "Register-Smart Contact Manager");
        model.addAttribute("user", new User());
        return "signup";
   }

   //handler for registering user

   @RequestMapping(value="/do_register",method=RequestMethod.POST)
   public String registerUser(@ModelAttribute("user") User user,@RequestParam(value="agreement",defaultValue = "false") Boolean agreement ,Model model,HttpSession session){
    
  //  model.addAttribut(user);
  try{
    if(!agreement){
        System.out.println("You have not agreed to the terms and conditions!");
        throw new Exception("You have not agreed to the terms and conditions!");
    }
  user.setRole("ROLE_USER");
  user.setEnabled(true);
  user.setImageUrl("default.png");
 User result=this.userRepository.save(user);
 model.addAttribute("user", new User()); 
 session.setAttribute("message", new Message("Successfully Registered!!","alert-success"));

  System.out.println("USER"+result);
  return "signup";
  }
  catch(Exception e){
    e.printStackTrace();
    model.addAttribute("user",user);
    session.setAttribute("message", new Message("Something went wrong!! "+e.getMessage(),"alert-danger"));
    return "signup";
  }
 // return "signup";
   }
}