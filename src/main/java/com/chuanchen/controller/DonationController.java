package com.chuanchen.controller;

import com.chuanchen.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chuanchenwine on 2017/5/4.
 */
@Controller
@RequestMapping("/donation")
public class DonationController {
    @Autowired
    DonationService donationService;
}
