package com.chuanchen.controller;

import com.chuanchen.entity.JsonResult;
import com.chuanchen.service.UserService;
import com.chuanchen.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by chuanchen-pc on 2017/3/11.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(HttpServletRequest request) {
        return "login";
    }
    @RequestMapping(value = "registry",method = RequestMethod.GET)
    public String alumnusRegistry(){
        return "xiaoyou_registry";
    }
    @RequestMapping(value = "checkaccount",method = RequestMethod.POST)
    public JsonResult checkAccount(@RequestParam(value = "name",required = true) String name,@RequestParam(value = "student_number") String studentNumber,@RequestParam(value = "start_age") String entryAge){
        Date date = CommonUtil.strToDate(entryAge);
        JsonResult jsonResult = new JsonResult();
        if(userService.isUserExist(name,studentNumber,date)){
            jsonResult.setStatusCode(500);
            jsonResult.setMessage("该用户已经存在,请不要重复注册!");
        }else {
            jsonResult.setStatusCode(200);
        }
        return jsonResult;
    }
}
