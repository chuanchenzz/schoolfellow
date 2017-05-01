package com.chuanchen.entity;

import java.util.Date;

/**
 * Created by chuanchenwine on 2017/5/1.
 */
public class DonationCompass {
    private int id;
    private String donationCompass;
    private String donationWay;
    private String donationFile;
    private Date setTime;

    public DonationCompass() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDonationCompass() {
        return donationCompass;
    }

    public void setDonationCompass(String donationCompass) {
        this.donationCompass = donationCompass;
    }

    public String getDonationWay() {
        return donationWay;
    }

    public void setDonationWay(String donationWay) {
        this.donationWay = donationWay;
    }

    public String getDonationFile() {
        return donationFile;
    }

    public void setDonationFile(String donationFile) {
        this.donationFile = donationFile;
    }

    public Date getSetTime() {
        return setTime;
    }

    public void setSetTime(Date setTime) {
        this.setTime = setTime;
    }
}
