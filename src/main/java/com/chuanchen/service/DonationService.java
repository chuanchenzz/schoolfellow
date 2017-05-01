package com.chuanchen.service;

import com.chuanchen.entity.Donation;
import com.chuanchen.entity.DonationCompass;

import java.util.List;

/**
 * Created by chuanchenwine on 2017/5/4.
 */
public interface DonationService {
    int getTotalCount();

    List<Donation> findDonations(int page,int limit);

    boolean deleteDonation(int id);

    int insertDonation(Donation donation);

    Donation findDonationById(int id);

    int insertDonationProcess(DonationCompass donationCompass);
}
