package com.chuanchen.controller;

import com.chuanchen.entity.Alumnus;
import com.chuanchen.entity.Project;
import com.chuanchen.entity.ProjectType;
import com.chuanchen.service.ProjectService;
import com.chuanchen.util.Constant;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by chuanchenwine on 2017/5/1.
 */
@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/findProjects",method = RequestMethod.GET)
    public String findProjects(@RequestParam("page") int page,@RequestParam("limit") int limit,@RequestParam("type") int type, Model model){
        int totalCount = projectService.getTotalCount();
        int pageCount = pageCount(totalCount);
        if(page <= 0){
            page = 1;
        }
        if(page > pageCount){
            page = pageCount;
        }
        if(limit != Constant.PROJECT_PAGE_COUNT){
            limit = Constant.PROJECT_PAGE_COUNT;
        }
        List<Project> projectList = projectService.findProjectList(page,limit,type);
        model.addAttribute("projectList",projectList);
        model.addAttribute("projectTotalCount",totalCount);
        model.addAttribute("projectPageCount",pageCount);
        if(ProjectType.codeToProjectType(type) == ProjectType.COPERRATION_PROJECT){
            model.addAttribute("title","合作项目表");
        }else if(ProjectType.codeToProjectType(type) == ProjectType.INCRUITMENT_INFO){
            model.addAttribute("title","招聘信息表");
        }
        return "admin/cooperrator_project_table";
    }
    //user
    @RequestMapping(value = "/findPublishProjects",method = RequestMethod.GET)
    public String findPublishProjects(@RequestParam("page") int page, @Param("limit") int limit, Model model, HttpSession httpSession){
        Alumnus alumnus = (Alumnus) httpSession.getAttribute("alumnus");
        if(alumnus == null){
            return "请重新登陆!";
        }
        int count = projectService.getCountByAlumnusId(alumnus.getId());
        int pageCount = pageCount(count);
        if(page <= 0){
            page = 1;
        }
        if(page > pageCount){
            page = pageCount;
        }
        if(limit != Constant.PROJECT_PAGE_COUNT){
            limit = Constant.PROJECT_PAGE_COUNT;
        }
        List<Project> projectList = projectService.findProjectList(page,limit,alumnus.getId());
        model.addAttribute("projectList",projectList);
        model.addAttribute("count",count);
        model.addAttribute("pageCount",pageCount);
        return "userAdmin/user_services_table";
    }
    @RequestMapping(value = "/projectInfo/{id}",method = RequestMethod.GET)
    public String findProjectInfo(@RequestParam("id") int id,Model model){
        Project project = projectService.findProjectById(id);
        if(project != null){
            model.addAttribute("project",project);
            return "admin/project_info";
        }else {
            return "";
        }
    }
    @RequestMapping(value = "/deleteProject/{id}",method = RequestMethod.GET)
    public String deleteProject(@RequestParam("id") int id,@RequestParam("type") int type){
        boolean deleteResult = projectService.deleteProject(id);
        if(deleteResult){
            return "redirect:/project/findProjects?page=1&type="+type;
        }else {
            return "";
        }
    }
    private int pageCount(int totalCount) {
        if(totalCount / Constant.PROJECT_PAGE_COUNT == 0){
            return 1;
        }
        return totalCount % Constant.PROJECT_PAGE_COUNT == 0 ? totalCount / Constant.PROJECT_PAGE_COUNT : totalCount / Constant.PROJECT_PAGE_COUNT + 1;
    }
}
