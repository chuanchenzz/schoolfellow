package com.chuanchen.entity;

/**
 * Created by chuanchenwine on 2017/5/4.
 */
public enum DonationType {
    PERSON_DONATION("个人捐赠", 1),
    COLLECTIVE_DONATION("集体捐赠", 2),
    COMPANY_DONATION("公司捐赠", 3);
    private String description;
    private int code;

    DonationType(String description, int code) {
        this.description = description;
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    public static DonationType desToType(String description) {
        if (description.equals("个人捐赠")) {
            return DonationType.PERSON_DONATION;
        } else if (description.equals("集体捐赠")) {
            return DonationType.COLLECTIVE_DONATION;
        } else if (description.equals("公司捐赠")) {
            return DonationType.COMPANY_DONATION;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static DonationType codeToType(int code) {
        switch (code) {
            case 1:
                return DonationType.PERSON_DONATION;
            case 2:
                return DonationType.COLLECTIVE_DONATION;
            case 3:
                return DonationType.COMPANY_DONATION;
            default:
                throw new IllegalArgumentException();
        }
    }
}
