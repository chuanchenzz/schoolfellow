package com.chuanchen.entity;

/**
 * Created by chuanchenwine on 2017/4/26.
 */
public class CommonCode {
    private int id;
    private String name;
    private int type;

    public CommonCode() {
    }

    public CommonCode(String name, int type) {
        this.name = name;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
