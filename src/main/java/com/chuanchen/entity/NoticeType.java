package com.chuanchen.entity;

/**
 * Created by chuanchenwine on 2017/4/24.
 */
public enum NoticeType {
    NOTICE_MESSAGE("通知消息", 1),
    ALUMNUS_MESSAGE("校友消息", 2),
    SCHOOL_DYNAMIC("母校动态", 3);
    private String description;
    private int type;

    NoticeType(String des, int type) {
        this.description = des;
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public static NoticeType desToType(String des) {
        if (des.equals("通知消息")) {
            return NoticeType.NOTICE_MESSAGE;
        } else if (des.equals("校友消息")) {
            return NoticeType.ALUMNUS_MESSAGE;
        } else if (des.equals("母校动态")) {
            return NoticeType.SCHOOL_DYNAMIC;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static NoticeType codeToType(int type) {
        switch (type) {
            case 1:
                return NoticeType.NOTICE_MESSAGE;
            case 2:
                return NoticeType.ALUMNUS_MESSAGE;
            case 3:
                return NoticeType.SCHOOL_DYNAMIC;
            default:
                throw new IllegalArgumentException();
        }
    }
}
