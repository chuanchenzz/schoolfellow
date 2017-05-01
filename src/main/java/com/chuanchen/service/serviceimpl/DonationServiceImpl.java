package com.chuanchen.service.serviceimpl;

import com.chuanchen.dao.DonationCompassMapper;
import com.chuanchen.dao.DonationMapper;
import com.chuanchen.entity.Donation;
import com.chuanchen.entity.DonationCompass;
import com.chuanchen.service.DonationService;
import com.chuanchen.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by chuanchenwine on 2017/5/4.
 */
@Service
public class DonationServiceImpl implements DonationService{
    @Autowired
    DonationMapper donationMapper;
    @Autowired
    DonationCompassMapper donationCompassMapper;

    public int getTotalCount() {
        return  donationMapper.getTotalCount();
    }

    public List<Donation> findDonations(int page, int limit) {
        int begin = (page - 1) * Constant.TOPALUMNUS_PAGE_COUNT;
        List<Donation> donationList = donationMapper.findDonations(begin,limit);
        return donationList == null ? Collections.<Donation>emptyList() : donationList;
    }

    public boolean deleteDonation(int id) {
        return donationMapper.deleteDonation(id) > 0 ? true : false;
    }

    public int insertDonation(Donation donation) {
        return donationMapper.insertDonation(donation);
    }

    public Donation findDonationById(int id) {
        return donationMapper.findDonationById(id);
    }

    public int insertDonationProcess(DonationCompass donationCompass) {
        return donationCompassMapper.insertDonationProcess(donationCompass);
    }
}
