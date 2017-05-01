package com.chuanchen.controller;

import com.chuanchen.entity.Donation;
import com.chuanchen.entity.DonationCompass;
import com.chuanchen.entity.DonationType;
import com.chuanchen.entity.JsonResult;
import com.chuanchen.service.DonationService;
import com.chuanchen.util.Constant;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by chuanchenwine on 2017/5/4.
 */
@Controller
@RequestMapping("/donation")
@PropertySource("classpath:variables.properties")
public class DonationController {
    @Autowired
    DonationService donationService;
    @Autowired
    Environment environment;

    @RequestMapping(value = "/findDonations", method = RequestMethod.GET)
    public String findDonations(@Param("page") int page, @Param("limit") int limit, Model model) {
        int totalCount = donationService.getTotalCount();
        int pageCount = pageCount(totalCount);
        if (page <= 0) {
            page = 1;
        }
        if (page > pageCount) {
            page = pageCount;
        }
        if (limit != Constant.DONATION_PAGE_COUNT) {
            limit = Constant.DONATION_PAGE_COUNT;
        }
        List<Donation> donationList = donationService.findDonations(page, limit);
        model.addAttribute("donationList", donationList);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("pageCount", pageCount);
        return "donate_table";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteDonation/{id}", method = RequestMethod.GET)
    public JsonResult deleteDonation(@PathVariable("id") int id) {
        boolean result = donationService.deleteDonation(id);
        JsonResult jsonResult = new JsonResult();
        if (result) {
            jsonResult.setStatusCode(200);
        } else {
            jsonResult.setStatusCode(500);
        }
        return jsonResult;
    }

    @RequestMapping(value = "/putDonation", method = RequestMethod.POST)
    public String putDonation(@RequestParam("donateName") String donateName, @RequestParam("donateAccount") long donateAccount, @RequestParam("donateType") int donateType,
                              @RequestParam("donateDescription") String donateDescription, Model model) {
        Donation donation = new Donation();
        donation.setDonateName(donateName.trim());
        donation.setDonateAccount(donateAccount);
        donation.setDonateTime(new Date());
        donation.setDonationType(DonationType.codeToType(donateType));
        donation.setDonationDescription(donateDescription);
        if (donationService.insertDonation(donation) > 0) {
            model.addAttribute("putDonation", true);
        } else {
            model.addAttribute("putDonation", false);
        }
        return "publish_donation";
    }

    @RequestMapping(value = "/donation/{id}", method = RequestMethod.GET)
    public String findDonation(@PathVariable("id") int id, Model model) {
        Donation donation = donationService.findDonationById(id);
        if (donation != null) {
            model.addAttribute("donation", donation);
            return "donation_detail";
        } else {
            return "donate_table";
        }
    }

    @RequestMapping(value = "/toDonationPage", method = RequestMethod.GET)
    public String toDonationPage() {
        return "publish_donation";
    }

    @RequestMapping(value = "/toDonationProcessPage", method = RequestMethod.GET)
    public String toDonationProcessPage() {
        return "donation_process";
    }
    @RequestMapping(value = "/setDonationProcess",method = RequestMethod.POST)
    public String setDonationProcess(@RequestParam("donationCompass") String donationCompass, @RequestParam("donationWay") String donationWay, @RequestPart("donationFile")MultipartFile donationFile,
                                     Model model, HttpServletRequest request){
        DonationCompass donationCompass1 = new DonationCompass();
        donationCompass1.setDonationCompass(donationCompass);
        donationCompass1.setDonationWay(donationWay);
        donationCompass1.setDonationFile(saveDonationFile(donationFile,request));
        donationCompass1.setSetTime(new Date());
        if(donationService.insertDonationProcess(donationCompass1) > 0){
            model.addAttribute("donationProcess",true);
            return "donation_process";
        }else {
            model.addAttribute("donationProcess",false);
            return "donation_process";
        }
    }
    private String saveDonationFile(MultipartFile image, HttpServletRequest request) {
        if (image.getName() != null && !image.getName().equals("") && image.getSize() > 0) {
            String basePath = request.getSession().getServletContext().getRealPath(environment.getProperty("donationFileDir"));
            File file = new File(basePath, image.getOriginalFilename());
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdir();
            }
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                image.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return file.getAbsolutePath();
        } else {
            return null;
        }
    }
    private int pageCount(int totalCount) {
        if (totalCount / Constant.DONATION_PAGE_COUNT == 0) {
            return 1;
        }
        return totalCount % Constant.DONATION_PAGE_COUNT == 0 ? totalCount / Constant.DONATION_PAGE_COUNT : totalCount / Constant.DONATION_PAGE_COUNT + 1;
    }

}
