package com.chuanchen.service.serviceimpl;

import com.chuanchen.dao.DonationMapper;
import com.chuanchen.service.DonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chuanchenwine on 2017/5/4.
 */
@Service
public class DonationServiceImpl implements DonationService{
    @Autowired
    DonationMapper donationMapper;
}
