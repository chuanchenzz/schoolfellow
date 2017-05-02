package com.chuanchen.entity;

/**
 * Created by chuanchenwine on 2017/5/2.
 */
public class TopAlumnus {
    private int id;
    private String name;
    private String description;
    private int alumnusId;

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

    public int getAlumnusId() {
        return alumnusId;
    }

    public void setAlumnusId(int alumnusId) {
        this.alumnusId = alumnusId;
    }
}
