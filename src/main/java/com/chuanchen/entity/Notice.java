package com.chuanchen.entity;

import java.util.Date;

/**
 * Created by chuanchenwine on 2017/4/24.
 */
public class Notice {
    private int id;
    private String title;
    private Date pubDate;
    private String content;
    private NoticeType type;
    private int userId;

    public Notice() {
    }

    public Notice(String title, Date pubDate, String content, NoticeType type) {
        this.title = title;
        this.pubDate = pubDate;
        this.content = content;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NoticeType getType() {
        return type;
    }

    public void setType(NoticeType type) {
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
