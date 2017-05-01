package com.chuanchen.service.serviceimpl;

import com.chuanchen.dao.ProjectMapper;
import com.chuanchen.entity.Project;
import com.chuanchen.service.ProjectService;
import com.chuanchen.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by chuanchenwine on 2017/5/1.
 */
@Service
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    ProjectMapper projectMapper;
    public int getTotalCount() {
        return projectMapper.getTotalCount();
    }

    public List<Project> findProjectList(int page, int limit,int type) {
        int begin = (page - 1) * Constant.PROJECT_PAGE_COUNT;
        List<Project> projectList = projectMapper.findProjectList(begin,limit,type);
        return projectList == null ? Collections.<Project>emptyList() : projectList;
    }

    public Project findProjectById(int id) {
        return projectMapper.findProjectById(id);
    }

    public boolean deleteProject(int id) {
        return projectMapper.deleteProject(id) > 0 ? true : false;
    }

    public int getCountByAlumnusId(int alumnusId) {
        return projectMapper.getCountByAlumnusId(alumnusId);
    }

    public List<Project> findProjectsByAlumnusId(int page, int limit, int alumnusId) {
        int begin = (page - 1) * Constant.PROJECT_PAGE_COUNT;
        List<Project> projectList = projectMapper.findProjectsByAlumnusId(begin,limit,alumnusId);
        return projectList == null ? Collections.<Project>emptyList() : projectList;
    }

    public boolean saveProject(Project project) {
        int result = projectMapper.saveProject(project);
        return result > 0 ? true : false;
    }
}
