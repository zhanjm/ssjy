package com.ssjy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("/index")
    public String login(Model model){
        model.addAttribute("test","Hello World！");
        return "index";
    }
}
