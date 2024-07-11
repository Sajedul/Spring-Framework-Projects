package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @RequestMapping("/home")
   public String home(Model model){
        System.out.println("This is home url");
        model.addAttribute("name","Cactus");
        model.addAttribute("id",14048);

        List<String> friends = new ArrayList<String>();
        friends.add("Alamin");
        friends.add("Showeb");
        friends.add("Suprim");
        model.addAttribute("f",friends);

       return "index";
   }
   @RequestMapping("/about")
   public String about (){
        System.out.println("this is the content of about page");
        return "about";
   }
   @RequestMapping("/help")
   public ModelAndView help(){
        System.out.println("this message is from help controller");
        //creating ModelAndView object
        ModelAndView modelAndView =new ModelAndView();
        modelAndView.addObject("name","Sajedul Islam Rahat");
        modelAndView.addObject("roll",180621);
       LocalDateTime time = LocalDateTime.now();
       modelAndView.addObject("clock",time);
        modelAndView.setViewName("help");
        return modelAndView;
   }
}
