package com.chuanchen.entity;

import java.util.Date;

/**
 * Created by chuanchenwine on 2017/5/5.
 */
public class Project {
    private int id;
    private String name;
    private Date uploadTime;
    private String content;
    private String uploadName;
    private String file;
    private ProjectType projectType;
    private Status status;
    private int alumnusId;
    public Project(){}

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

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUploadName() {
        return uploadName;
    }

    public void setUploadName(String uploadName) {
        this.uploadName = uploadName;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public ProjectType getProjectType() {
        return projectType;
    }

    public void setProjectType(ProjectType projectType) {
        this.projectType = projectType;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getAlumnusId() {
        return alumnusId;
    }

    public void setAlumnusId(int alumnusId) {
        this.alumnusId = alumnusId;
    }
}
