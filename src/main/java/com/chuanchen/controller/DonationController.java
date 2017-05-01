package com.chuanchen.controller;

import com.chuanchen.entity.Donation;
import com.chuanchen.entity.DonationType;
import com.chuanchen.entity.JsonResult;
import com.chuanchen.service.DonationService;
import com.chuanchen.util.Constant;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    @ResponseBody
    @RequestMapping(value = "/deleteDonation/{id}",method = RequestMethod.GET)
    public JsonResult deleteDonation(@PathVariable("id") int id){
        boolean result = donationService.deleteDonation(id);
        JsonResult jsonResult = new JsonResult();
        if(result){
            jsonResult.setStatusCode(200);
        }else {
            jsonResult.setStatusCode(500);
        }
        return jsonResult;
    }
    @RequestMapping(value = "/putDonation",method = RequestMethod.POST)
    public String putDonation(@RequestParam("donateName") String donateName,@RequestParam("donateAccount") long donateAccount,@RequestParam("donateType") int donateType,
                              @RequestParam("donateDescription") String donateDescription,Model model){
        Donation donation = new Donation();
        donation.setDonateName(donateName.trim());
        donation.setDonateAccount(donateAccount);
        donation.setDonateTime(new Date());
        donation.setDonationType(DonationType.codeToType(donateType));
        donation.setDonationDescription(donateDescription);
        if(donationService.insertDonation(donation) > 0){
            model.addAttribute("putDonation",true);
        }else {
            model.addAttribute("putDonation",false);
        }
        return "";
    }
    @RequestMapping(value = "/donation/{id}",method = RequestMethod.GET)
    public String findDonation(@PathVariable("id") int id,Model model){
        Donation donation = donationService.findDonationById(id);
        if(donation != null){
            model.addAttribute("donation",donation);
            return "donation_detail";
        }else {
            return "donate_table";
        }
    }
    @RequestMapping(value = "/toDonationPage",method = RequestMethod.GET)
    public String toDonationPage(){
        return "publish_donation";
    }
    private int pageCount(int totalCount) {
        if(totalCount / Constant.DONATION_PAGE_COUNT == 0){
            return 1;
        }
        return totalCount % Constant.DONATION_PAGE_COUNT == 0 ? totalCount / Constant.DONATION_PAGE_COUNT : totalCount / Constant.DONATION_PAGE_COUNT + 1;
    }

}
