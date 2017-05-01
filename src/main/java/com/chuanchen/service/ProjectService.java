package com.chuanchen.service;

import com.chuanchen.entity.Project;

import java.util.List;

/**
 * Created by chuanchenwine on 2017/5/1.
 */
public interface ProjectService {

    int getTotalCount();

    List<Project> findProjectList(int page,int limit,int type);

    Project findProjectById(int id);

    boolean deleteProject(int id);

    int getCountByAlumnusId(int alumnusId);

    List<Project> findProjectsByAlumnusId(int page,int limit,int alumnusId);
}
