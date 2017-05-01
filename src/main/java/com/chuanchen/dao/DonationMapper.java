package com.chuanchen.dao;

import com.chuanchen.entity.Donation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chuanchenwine on 2017/5/4.
 */
public interface DonationMapper {
    int getTotalCount();

    List<Donation> findDonations(@Param("begin") int begin,@Param("limit") int limit);

    int deleteDonation(@Param("id") int id);

    int insertDonation(Donation donation);

    Donation findDonationById(@Param("id") int id);
}
