package com.chuanchen.controller;

import com.chuanchen.entity.Donation;
import com.chuanchen.service.DonationService;
import com.chuanchen.util.Constant;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by chuanchenwine on 2017/5/4.
 */
@Controller
@RequestMapping("/donation")
public class DonationController {
    @Autowired
    DonationService donationService;
    @RequestMapping(value = "/findDonations",method = RequestMethod.GET)
    public String findDonations(@Param("page") int page, @Param("limit") int limit, Model model){
        int totalCount = donationService.getTotalCount();
        int pageCount = pageCount(totalCount);
        if(page <= 0){
            page = 1;
        }
        if(page > pageCount){
            page = pageCount;
        }
        if(limit != Constant.DONATION_PAGE_COUNT){
            limit = Constant.DONATION_PAGE_COUNT;
        }
        List<Donation> donationList = donationService.findDonations(page,limit);
        model.addAttribute("donationList",donationList);
        model.addAttribute("totalCount",totalCount);
        model.addAttribute("pageCount",pageCount);
        return "donate_table";
    }
    private int pageCount(int totalCount) {
        if(totalCount / Constant.DONATION_PAGE_COUNT == 0){
            return 1;
        }
        return totalCount % Constant.DONATION_PAGE_COUNT == 0 ? totalCount / Constant.DONATION_PAGE_COUNT : totalCount / Constant.DONATION_PAGE_COUNT + 1;
    }

}
