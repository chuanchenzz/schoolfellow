package com.chuanchen.controller;

import com.chuanchen.entity.Alumnus;
import com.chuanchen.entity.JsonResult;
import com.chuanchen.entity.User;
import com.chuanchen.service.UserService;
import com.chuanchen.util.CommonUtil;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.nio.cs.US_ASCII;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by chuanchen-pc on 2017/3/11.
 */
@Controller
@RequestMapping("/user")
@SessionAttributes(value = {"alumnus", "user"})
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(HttpServletRequest request) {
        return "login";
    }

    @RequestMapping(value = "registry", method = RequestMethod.GET)
    public String alumnusRegistry() {
        return "xiaoyou_registry";
    }

    @ResponseBody
    @RequestMapping(value = "/checkaccount", method = RequestMethod.POST)
    public JsonResult checkAccount(@RequestParam(value = "name", required = true) String name, @RequestParam(value = "student_number") String studentNumber, @RequestParam(value = "start_age") String entryAge, Model model, HttpSession session) {
        if(session.getAttribute("alumnus") != null){
            session.removeAttribute("alumnus");
        }
        if(session.getAttribute("user") != null){
            session.removeAttribute("user");
        }
        Date date = CommonUtil.strToDate(entryAge);
        Alumnus alumnus = new Alumnus();
        alumnus.setName(name);
        alumnus.setStudentNumber(studentNumber);
        alumnus.setEntranceAge(date);
        model.addAttribute("alumnus", alumnus);
        JsonResult jsonResult = new JsonResult();
//        if(userService.isAlumnusExist(name,studentNumber,date)){
//            jsonResult.setStatusCode(500);
//            jsonResult.setMessage("该用户已经存在,请不要重复注册!");
//        }else {
//            jsonResult.setStatusCode(200);
//        }
        jsonResult.setStatusCode(200);
        return jsonResult;
    }

    @ResponseBody
    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public JsonResult addUser(@RequestParam(value = "userName", required = true) String userName, @RequestParam(value = "password", required = true) String password, Model model) {
        JsonResult jsonResult = new JsonResult();
//        if (userService.isUserExist(userName)) {
//            jsonResult.setStatusCode(500);
//            jsonResult.setMessage("该用户名已经存在,请修改用户名!");
//        } else {
//            User user = new User();
//            user.setUserName(userName);
//            user.setPassword(password);
//            model.addAttribute("user", user);
//            jsonResult.setStatusCode(200);
//        }
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        model.addAttribute("user",user);
        jsonResult.setStatusCode(200);
        return jsonResult;
    }
}
