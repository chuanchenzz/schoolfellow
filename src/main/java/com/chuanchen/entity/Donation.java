package com.chuanchen.entity;

import java.util.Date;

/**
 * Created by chuanchenwine on 2017/5/4.
 */
public class Donation {
    private int id;
    private String donateName;
    private long donateAccount;
    private Date donateTime;
    private DonationType donationType;

    public Donation() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDonateName() {
        return donateName;
    }

    public void setDonateName(String donateName) {
        this.donateName = donateName;
    }

    public long getDonateAccount() {
        return donateAccount;
    }

    public void setDonateAccount(long donateAccount) {
        this.donateAccount = donateAccount;
    }

    public Date getDonateTime() {
        return donateTime;
    }

    public void setDonateTime(Date donateTime) {
        this.donateTime = donateTime;
    }

    public DonationType getDonationType() {
        return donationType;
    }

    public void setDonationType(DonationType donationType) {
        this.donationType = donationType;
    }
}
