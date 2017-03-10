package com.chuanchen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chuanchen-pc on 2017/3/10.
 */
@Controller
@RequestMapping("/index")
public class WelcomeController {
    @RequestMapping("/welcome")
    public String welcomePage(){
        return "welcome";
    }
}
