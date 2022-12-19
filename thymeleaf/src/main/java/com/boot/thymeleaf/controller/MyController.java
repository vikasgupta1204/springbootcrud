package com.boot.thymeleaf.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(Model model) {
        System.out.println("About handler");
        // to send the data from handler to the view
        model.addAttribute("name", "vikas");
        model.addAttribute("currentDate", DateFormat.DAY_OF_WEEK_IN_MONTH_FIELD);
        return "about";
    }

    /*
     * @RequestMapping(value="/about",method = RequestMethod.GET) and
     * 
     * @GetMapping("/about") are same
     */

    @GetMapping("/example-loop")
    public String iterateController(Model m) {

        m.addAttribute("list",List.of("Vikas","Raju","Vivek","Gaurav","Shekhar"));
        return "iterate";
    }
}