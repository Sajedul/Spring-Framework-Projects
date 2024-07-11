package com.springmvc.controller;

import com.springmvc.model.User;
import com.springmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ContactController {
    @Autowired
    private UserService userService;
   @ModelAttribute
    public void commonDataModel(Model m) {
        m.addAttribute("Header", "Learn Spring MVC");
        m.addAttribute("Desc", "Java Practice ");
        System.out.println("common Data is loaded");
    }
    @RequestMapping("/contact")
    public String showForm(Model m){
        /*m.addAttribute("Header","LearingSpringMVC");
        m.addAttribute("Description","HelloLearners");*/
        return "contact";
    }
    @RequestMapping(path ="/processform", method= RequestMethod.POST)
    public String handleForm(@ModelAttribute User user, Model model){

        System.out.println(user);
        //model.addAttribute("user",user);

        /*model.addAttribute("Header", "SpringMVC");
        model.addAttribute("Desc", "PracticeJava ");*/
        int createdUser=this.userService.createUser(user);
        model.addAttribute("msg","User created with Id"+createdUser);
        return "success";
    }
}

/*
 @RequestMapping(path ="/processform", method= RequestMethod.POST)
    public String handleForm(@RequestParam("email")String userEmail,
                             @RequestParam("name")String userName,
                             @RequestParam("password")String userPassword, Model model){
        System.out.println("User email ID is:"+ userEmail);
        System.out.println("User email ID is:"+ userName);
        System.out.println("User email ID is:"+ userPassword);

        User user = new User();
        user.setEmail("userEmail");
        user.setName("userName");
        user.setPassword("userPassword");

        System.out.println(user);

       // model.addAttribute("email", userEmail);
        //model.addAttribute("name", userName);
        //model.addAttribute("password", userPassword);

        model.addAttribute("user",user);
        return "success";
    }

 */