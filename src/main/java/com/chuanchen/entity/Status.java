package com.chuanchen.entity;

/**
 * Created by chuanchenwine on 2017/4/25.
 */
public enum Status {
    NOT_AUDIT("未审核", 0),
    NOT_PASS("未通过", 1),
    PASSE("通过", 2);
    private String description;
    private int statusCode;

    Status(String description, int statusCode) {
        this.description = description;
        this.statusCode = statusCode;
    }

    public String getDescription() {
        return description;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public static Status desToStatus(String description) {
        if (description.equals("未审核")) {
            return Status.NOT_AUDIT;
        } else if (description.equals("未通过")) {
            return Status.NOT_PASS;
        } else if (description.equals("通过")) {
            return Status.PASSE;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static Status codeToStatus(int statusCode) {
        switch (statusCode) {
            case 0:
                return Status.NOT_AUDIT;
            case 1:
                return Status.NOT_PASS;
            case 2:
                return Status.PASSE;
            default:
                throw new IllegalArgumentException();
        }
    }
}
