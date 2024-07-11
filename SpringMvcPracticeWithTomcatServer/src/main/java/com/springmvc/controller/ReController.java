package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ReController {
    @RequestMapping("/one")
    public RedirectView one(){
        System.out.println("This is from Hamdler One");
       RedirectView redirectView = new RedirectView();
       redirectView.setUrl("/enjoy");
        return redirectView;
    }
    @RequestMapping("/enjoy")
    public String two(){
        System.out.println("This is from Second Handler");
        return "contact";
    }
}

//Redirect Using Prefix

  /*  @RequestMapping("/one")
    public String one(){
        System.out.println("This is from Hamdler One");
        return "redirect:/enjoy";
    }
    @RequestMapping("/enjoy")
    public String two(){
        System.out.println("This is from Second Handler");
        return "contact";
    }*/