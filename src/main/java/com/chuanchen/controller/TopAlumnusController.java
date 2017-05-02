package com.chuanchen.controller;

import com.chuanchen.service.TopAlumnusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chuanchenwine on 2017/5/2.
 */
@Controller
@RequestMapping("/topAlumnus")
public class TopAlumnusController {
    @Autowired
    TopAlumnusService topAlumnusService;
}
