package com.chuanchen.controller;

import com.chuanchen.entity.Alumnus;
import com.chuanchen.entity.Project;
import com.chuanchen.entity.ProjectType;
import com.chuanchen.entity.Status;
import com.chuanchen.service.ProjectService;
import com.chuanchen.util.Constant;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by chuanchenwine on 2017/5/1.
 */
@Controller
@RequestMapping("/project")
@PropertySource("classpath:variables.properties")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    @Autowired
    Environment environment;
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
            return "not_found!";
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
    @RequestMapping(value = "/user/projectInfo/{id}",method = RequestMethod.GET)
    public String projectInfo(@RequestParam("id") int id,Model model){
        Project project = projectService.findProjectById(id);
        if(project != null){
            model.addAttribute("project",project);
            return "userAdmin/user_project_detail";
        }else {
            return "";
        }
    }
    @RequestMapping(value = "/publishServicePage",method = RequestMethod.GET)
    public String publishServicePage(){
        return "userAdmin/user_publish_service";
    }
    //user
    @RequestMapping(value = "/publishAlumnusProject",method = RequestMethod.POST)
    public String publishAlumnusProject(@RequestParam("project_name") String projectTitle, @RequestParam("serviceType") int projectType,
                                        @RequestParam("description") String projectContent, @RequestPart("serviceFile")MultipartFile projectFile,Model model,HttpSession httpSession,
                                        HttpServletRequest request){
        Alumnus alumnus = (Alumnus) httpSession.getAttribute("alumnus");
        if(alumnus == null){
            return "not_found!";
        }
        Project project = new Project();
        project.setName(projectTitle);
        project.setProjectType(ProjectType.codeToProjectType(projectType));
        project.setContent(projectContent);
        project.setFile(saveProjectFile(projectFile,request));
        project.setAlumnusId(alumnus.getId());
        project.setStatus(Status.NOT_AUDIT);
        project.setUploadTime(new Date());
        project.setUploadName(alumnus.getName());
        if(projectService.saveProject(project)){
            model.addAttribute("addProject",200);
        }else {
            model.addAttribute("addProject",500);
        }
        return "userAdmin/user_publish_service";
    }
    private String saveProjectFile(MultipartFile image, HttpServletRequest request) {
        if (image.getName() != null && !image.getName().equals("") && image.getSize() > 0) {
            String basePath = request.getSession().getServletContext().getRealPath(environment.getProperty("serviceFileDir"));
            File file = new File(basePath, image.getOriginalFilename());
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdir();
            }
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                image.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return file.getAbsolutePath();
        } else {
            return null;
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
