package com.chuanchen.entity;

/**
 * Created by chuanchenwine on 2017/4/21.
 */
public enum CodeType {
    CITY("城市", 1),
    EDUCATION("学历", 2),
    INDUSTRY("行业", 3),
    NATION("民族", 4),
    IDENTITY("身份", 5),
    COMPANY_NATURE("公司性质", 6);
    private String description;
    private int code;

    CodeType(String description, int code) {
        this.description = description;
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    public static CodeType getTypeByDescription(String description) {
        if (description.equals("城市")) {
            return CodeType.CITY;
        } else if (description.equals("学历")) {
            return CodeType.EDUCATION;
        } else if (description.equals("行业")) {
            return CodeType.INDUSTRY;
        } else if (description.equals("民族")) {
            return CodeType.NATION;
        } else if (description.equals("身份")) {
            return CodeType.IDENTITY;
        } else if (description.equals("公司性质")) {
            return CodeType.COMPANY_NATURE;
        } else {
            throw new IllegalArgumentException("can't match type!");
        }
    }

    public static CodeType getTypeByCode(int code) {
        switch (code) {
            case 1:
                return CodeType.CITY;
            case 2:
                return CodeType.EDUCATION;
            case 3:
                return CodeType.INDUSTRY;
            case 4:
                return CodeType.NATION;
            case 5:
                return CodeType.IDENTITY;
            case 6:
                return CodeType.COMPANY_NATURE;
            default:
                throw new IllegalArgumentException("can't match type!");
        }
    }
}
