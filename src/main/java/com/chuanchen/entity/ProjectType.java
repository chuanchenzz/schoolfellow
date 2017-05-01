package com.chuanchen.entity;

/**
 * Created by chuanchenwine on 2017/5/5.
 */
public enum ProjectType {
    COPERRATION_PROJECT("合作项目", 1),
    INCRUITMENT_INFO("招聘信息", 2);
    private String description;
    private int code;

    ProjectType(String description, int code) {
        this.description = description;
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    public static ProjectType codeToProjectType(int code) {
        switch (code) {
            case 1:
                return ProjectType.COPERRATION_PROJECT;
            case 2:
                return ProjectType.INCRUITMENT_INFO;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static ProjectType desToProjectType(String description) {
        if (description.equals("合作项目")) {
            return ProjectType.COPERRATION_PROJECT;
        } else if (description.equals("招聘信息")) {
            return ProjectType.INCRUITMENT_INFO;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
