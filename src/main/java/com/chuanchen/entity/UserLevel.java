package com.chuanchen.entity;

/**
 * Created by chuanchenwine on 2017/4/24.
 */
public enum UserLevel {
    NORMAL_USER("普通用户", 0),
    ADMIN_USER("管理员", 1);
    private String name;
    private int level;

    UserLevel(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public static UserLevel nameToUserLevel(String name) {
        if (name.equals("普通用户")) {
            return UserLevel.NORMAL_USER;
        } else if (name.equals("管理员")) {
            return UserLevel.ADMIN_USER;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static UserLevel levelToUserLevel(int level) {
        switch (level) {
            case 0:
                return UserLevel.NORMAL_USER;
            case 1:
                return UserLevel.ADMIN_USER;
            default:
                throw new IllegalArgumentException();
        }
    }
}
