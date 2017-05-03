package com.chuanchen.entity;

import java.util.Date;

/**
 * Created by chuanchenwine on 2017/5/2.
 */
public class TopAlumnus {
    private int id;
    private String name;
    private String avatar;
    private String description;
    private Date uploadDate;
    public TopAlumnus() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
