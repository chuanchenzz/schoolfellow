package com.chuanchen.entity;

/**
 * Created by chuanchenwine on 2017/4/20.
 */
public class User {
    private int id;
    private int alumnusId;
    private String userName;
    private String password;

    public User() {
    }

    public User(int id, int alumnusId, String userName, String password) {
        this.id = id;
        this.alumnusId = alumnusId;
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlumnusId() {
        return alumnusId;
    }

    public void setAlumnusId(int alumnusId) {
        this.alumnusId = alumnusId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
