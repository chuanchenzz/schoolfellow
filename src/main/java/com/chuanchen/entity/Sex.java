package com.chuanchen.entity;

/**
 * Created by chuanchenwine on 2017/4/20.
 */
public enum Sex {
    MALE("男", 1),
    FAMALE("女", 2);
    private String sex;
    private int code;

    Sex(String sex, int code) {
        this.sex = sex;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getSex() {
        return sex;
    }

    public static Sex codeToSex(int code) {
        switch (code) {
            case 1:
                return MALE;
            case 2:
                return FAMALE;
            default:
                throw new IllegalArgumentException("code id illegal!");
        }
    }

    public static Sex sexStrToSex(String sex) {
        if (sex.equals("男")) {
            return MALE;
        } else if (sex.equals("女")) {
            return FAMALE;
        } else {
            throw new IllegalArgumentException("sex is illegal!");
        }
    }
}
