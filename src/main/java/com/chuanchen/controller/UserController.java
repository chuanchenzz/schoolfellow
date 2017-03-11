package com.chuanchen.controller;

import com.chuanchen.entity.User;
import com.chuanchen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by chuanchen-pc on 2017/3/11.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, Model model) {
        long id = userRepository.findUserByuserNameAndPassword(user.getUserName(), user.getPassword());
        if (id <= 0) {
            model.addAttribute("errorinfo", "");
            return "login";
        }
        model.addAttribute("userid", id);
        return "redirect:/user/{userid}";
    }

    @RequestMapping(value = "/{userid}")
    public String loginIndexPage(@PathVariable("userid") long userId, Model model) {
        User user = userRepository.findUserById(userId);
        model.addAttribute("user", user);
        return "";
    }
}
