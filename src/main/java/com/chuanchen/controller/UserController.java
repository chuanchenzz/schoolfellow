package com.chuanchen.controller;

import com.chuanchen.entity.*;
import com.chuanchen.service.BaseDataService;
import com.chuanchen.service.UserService;
import com.chuanchen.util.CommonUtil;
import com.chuanchen.util.Constant;
import org.apache.tools.ant.taskdefs.condition.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by chuanchen-pc on 2017/3/11.
 */
@Controller
@RequestMapping("/user")
@SessionAttributes(value = {"user"})
@PropertySource("classpath:variables.properties")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    BaseDataService baseDataService;

    @Autowired
    Environment environment;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String toTestPage() {
        return "test";
    }

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String loginPage(HttpServletRequest request) {
        return "login";
    }

    @RequestMapping(value = "registry", method = RequestMethod.GET)
    public String alumnusRegistry(HttpServletRequest  request) {
        return "xiaoyou_registry";
    }

    @ResponseBody
    @RequestMapping(value = "/checkaccount", method = RequestMethod.POST)
    public JsonResult checkAccount(@RequestParam(value = "name", required = true) String name, @RequestParam(value = "student_number") String studentNumber, @RequestParam(value = "start_age") String entryAge, Model model, HttpSession session) {
        if (session.getAttribute("user") != null) {
            session.removeAttribute("user");
        }
        JsonResult jsonResult = new JsonResult();
        if(userService.isAlumnusExist(name,studentNumber)){
            jsonResult.setStatusCode(500);
            jsonResult.setMessage("该用户已经存在,请不要重复注册!");
        }else {
            jsonResult.setStatusCode(200);
        }
        return jsonResult;
    }
    @RequestMapping(value = "/findUsers",method = RequestMethod.GET)
    public String findUsers(@RequestParam(value = "page",required = true) int page,@RequestParam(value = "limit",required = false,defaultValue = "15") int limit,Model model){
        int totalPage = userService.getTotalPage();
        if(page <= 0){
            page = 1;
        }
        if(page > totalPage){
            page = totalPage;
        }
        if(limit <= 0 || limit > 15){
            limit = 15;
        }
        List<Alumnus> alumnusList = userService.findAlumnuses(page,limit);
        model.addAttribute("alumnusList",alumnusList);
        model.addAttribute("totalCount",totalPage);
        model.addAttribute("page",page);
        return "admin/xiaoyou_table";
    }
    private int pageCount(int totalCount) {
        if(totalCount / Constant.ALUMNUS_PAGE_COUNT == 0){
            return 1;
        }
        return totalCount % Constant.ALUMNUS_PAGE_COUNT == 0 ? totalCount / Constant.ALUMNUS_PAGE_COUNT : totalCount / Constant.ALUMNUS_PAGE_COUNT + 1;
    }
    @ResponseBody
    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public JsonResult addUser(@RequestParam(value = "userName", required = true) String userName, @RequestParam(value = "password", required = true) String password, Model model) {
        JsonResult jsonResult = new JsonResult();
        if (userService.isUserExist(userName)) {
            jsonResult.setStatusCode(500);
            jsonResult.setMessage("该用户名已经存在,请修改用户名!");
        } else {
            User user = new User();
            user.setUserName(userName);
            user.setPassword(password);
            user.setLevel(UserLevel.NORMAL_USER);
            model.addAttribute("user", user);
            //获取地区集合
            List<CommonCode> addressList = baseDataService.getCommonCodesByType(CodeType.CITY);
            if(addressList == null){
                addressList = Collections.emptyList();
            }
            //获取民族集合
            List<CommonCode> nationList = baseDataService.getCommonCodesByType(CodeType.NATION);
            if(nationList == null){
                nationList = Collections.emptyList();
            }
            //获取学历集合
            List<CommonCode> academicList = baseDataService.getCommonCodesByType(CodeType.EDUCATION);
            if(academicList == null){
                nationList = Collections.emptyList();
            }
            //获取行业集合
            List<CommonCode> industryList = baseDataService.getCommonCodesByType(CodeType.INDUSTRY);
            if(industryList == null){
                industryList = Collections.emptyList();
            }
            //获取身份集合
            List<CommonCode> identifyList = baseDataService.getCommonCodesByType(CodeType.IDENTITY);
            if(identifyList == null){
                identifyList = Collections.emptyList();
            }
            //获取公司性质集合
            List<CommonCode> natureList = baseDataService.getCommonCodesByType(CodeType.COMPANY_NATURE);
            if(nationList == null){
                nationList = Collections.emptyList();
            }
            jsonResult.setStatusCode(200);
            Map<String,Object> params = new HashMap<String, Object>();
            params.put("addressList",addressList);
            params.put("nationList",nationList);
            params.put("academicList",academicList);
            params.put("industryList",industryList);
            params.put("identifyList",identifyList);
            params.put("natureList",natureList);
            jsonResult.setMapParams(params);
        }
        return jsonResult;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam("name") String name, @RequestParam("sex") String sex, @RequestPart("avatar") MultipartFile avatar,@RequestParam("nation") String nation,
                               @RequestParam("identity") String identity, @RequestParam("idCard") String idCard, @RequestParam("birthday") String birthday,
                               @RequestParam("birthPlace") String birthPlace, @RequestParam("address") String address, @RequestParam("phone") String phone,
                               @RequestParam("email") String email, @RequestParam("education") String education, @RequestParam("entranceAge") String entranceAge,
                               @RequestParam("graduteAge") String graduteAge, @RequestParam("instructor") String instructor, @RequestParam("academic") String academic, @RequestParam("profession") String profession,
                               @RequestParam("classs") String classs, @RequestParam("workAddress") String workAddress, @RequestParam("inductive") String inductive,
                               @RequestParam("organization") String organization, @RequestParam("industry") String industry, @RequestParam("organizationNature") String organizationNature,
                               @RequestParam("department") String department, @RequestParam("job") String job, @RequestParam("student_number") String studentNumber, HttpSession session, HttpServletRequest request) {
        Alumnus alumnus = new Alumnus();
        alumnus.setName(name);
        alumnus.setSex(Sex.codeToSex(Integer.valueOf(sex)));
        String path = null;
        if((path = saveAvatar(avatar,request)) != null){
            alumnus.setAvatar(path);
        }
        alumnus.setNation(baseDataService.getCommonCodeFromCacheByName(CodeType.NATION.getCode(),nation));
        alumnus.setStudentNumber(studentNumber);
        alumnus.setIdentity(baseDataService.getCommonCodeFromCacheByName(CodeType.IDENTITY.getCode(),identity));
        alumnus.setIdCard(idCard);
        alumnus.setBirthday(CommonUtil.isDatePattern(birthday) ? birthday : null);
        alumnus.setBirthPlace(baseDataService.getCommonCodeFromCacheByName(CodeType.CITY.getCode(),birthPlace));
        alumnus.setAddress(baseDataService.getCommonCodeFromCacheByName(CodeType.CITY.getCode(),address));
        alumnus.setPhone(phone);
        alumnus.setEmail(email);
        alumnus.setEducation(baseDataService.getCommonCodeFromCacheByName(CodeType.EDUCATION.getCode(),education));
        alumnus.setEntranceAge(CommonUtil.isDatePattern(entranceAge) ? entranceAge : null);
        alumnus.setGraduteAge(CommonUtil.isDatePattern(graduteAge) ? graduteAge : null);
        alumnus.setInstructor(instructor);
        alumnus.setAcademic(academic);
        alumnus.setProfession(profession);
        alumnus.setClasss(classs);
        alumnus.setWorkAddress(baseDataService.getCommonCodeFromCacheByName(CodeType.CITY.getCode(),workAddress));
        alumnus.setInductive(CommonUtil.isDatePattern(inductive) ? inductive : null);
        alumnus.setOrganization(organization);
        alumnus.setIndustry(baseDataService.getCommonCodeFromCacheByName(CodeType.INDUSTRY.getCode(),industry));
        alumnus.setOrganizationNature(baseDataService.getCommonCodeFromCacheByName(CodeType.COMPANY_NATURE.getCode(),organizationNature));
        alumnus.setDepartment(department);
        alumnus.setJob(job);
        if (session.getAttribute("user") == null) {
            return "index";
        }
        User user = (User) session.getAttribute("user");
        if (userService.saveUserAndAlumnus(user, alumnus) > 0) {
            return "index";
        } else {
            return "xiaoyou_registry";
        }
    }
    public String saveAvatar(MultipartFile image,HttpServletRequest request){
        if(image.getName() != null && !image.getName().equals("") && image.getSize() > 0){
            String basePath = request.getSession().getServletContext().getRealPath(environment.getProperty("avatarsDir"));
            File file = new File(basePath,image.getOriginalFilename());
            if(!file.getParentFile().exists()){
                file.getParentFile().mkdir();
            }
            if(!file.exists()){
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
        }else {
            return null;
        }
    }
    //admin
    @RequestMapping(value = "/alumnusinfo/{id}", method = RequestMethod.GET)
    public String getAlumnusInfo(@PathVariable("id") String id,Model model) {
        JsonResult jsonResult = new JsonResult();
        Alumnus alumnus = userService.getAlumnusById(Integer.valueOf(id));
        if (alumnus == null) {
            return "admin/xiaoyou_table";
        } else {
            model.addAttribute("alumnus",alumnus);
            return "admin/xiaoyou_detail";
        }
    }
    @RequestMapping(value = "/cityAlumnus",method = RequestMethod.GET)
    public String getCityAlumnus(@RequestParam("page") int page,@RequestParam("limit") int limit, Model model, HttpSession httpSession){
        Alumnus alumnus = (Alumnus) httpSession.getAttribute("alumnus");
        if(alumnus == null){
            return "not_found";
        }
        int cityCount = userService.getCountByCity(alumnus.getWorkAddress().getId());
        int pageCount = pageCount(cityCount);
        if(page <= 0){
            page = 1;
        }
        if(page > pageCount){
            page = pageCount;
        }
        if(limit != Constant.ALUMNUS_PAGE_COUNT){
            limit = Constant.ALUMNUS_PAGE_COUNT;
        }
        List<Alumnus> alumnusList = userService.getAlumnusesByCity(page,limit,alumnus.getWorkAddress().getId());
        model.addAttribute("alumnusList",alumnusList);
        model.addAttribute("totalCount",cityCount);
        model.addAttribute("pageCount",pageCount);
        return "userAdmin/user_city_alumnus";
    }
    //user
    @RequestMapping(value = "/getSelfInfo",method = RequestMethod.GET)
    public String getSelfInfo(Model model,HttpSession httpSession){
        Alumnus alumnus = (Alumnus) httpSession.getAttribute("alumnus");
        if(alumnus == null){
            return "not_found";
        }
        //获取地区集合
        List<CommonCode> addressList = baseDataService.getCommonCodesByType(CodeType.CITY);
        if(addressList == null){
            addressList = Collections.emptyList();
        }
        //获取民族集合
        List<CommonCode> nationList = baseDataService.getCommonCodesByType(CodeType.NATION);
        if(nationList == null){
            nationList = Collections.emptyList();
        }
        //获取学历集合
        List<CommonCode> academicList = baseDataService.getCommonCodesByType(CodeType.EDUCATION);
        if(academicList == null){
            nationList = Collections.emptyList();
        }
        //获取行业集合
        List<CommonCode> industryList = baseDataService.getCommonCodesByType(CodeType.INDUSTRY);
        if(industryList == null){
            industryList = Collections.emptyList();
        }
        //获取身份集合
        List<CommonCode> identifyList = baseDataService.getCommonCodesByType(CodeType.IDENTITY);
        if(identifyList == null){
            identifyList = Collections.emptyList();
        }
        //获取公司性质集合
        List<CommonCode> natureList = baseDataService.getCommonCodesByType(CodeType.COMPANY_NATURE);
        if(nationList == null){
            nationList = Collections.emptyList();
        }
        model.addAttribute("addressList",addressList);
        model.addAttribute("nationList",nationList);
        model.addAttribute("academicList",academicList);
        model.addAttribute("industryList",industryList);
        model.addAttribute("identifyList",identifyList);
        model.addAttribute("natureList",natureList);
        model.addAttribute("alumnus",alumnus);
        return "userAdmin/user_personal_info";
    }
    @ResponseBody
    @RequestMapping(value = "/deletealumnus/{id}", method = RequestMethod.GET)
    public JsonResult deleteAlumnus(@PathVariable("id") String id) {
        JsonResult jsonResult = new JsonResult();
        int result = userService.deleteAlumnusAndUserById(Integer.valueOf(id));
        if (result > 0) {
            jsonResult.setStatusCode(200);
        } else {
            jsonResult.setStatusCode(404);
            jsonResult.setMessage("删除用户失败!");
        }
        return jsonResult;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String userLogin(@RequestParam("userName") String userName, @RequestParam("password") String password,HttpSession httpSession,Model model) {
        password = CommonUtil.md5Password(password.trim());
        User user = userService.findUserByNameAndPassword(userName, password);
        if (user != null) {
            switch (user.getLevel()){
                case NORMAL_USER:
                {
                    Alumnus alumnus = userService.getAlumnusById(user.getAlumnusId());
                    httpSession.setAttribute("alumnus",alumnus);
                }
            }
            model.addAttribute("level", user.getLevel().getLevel());
            return "redirect:/user/backManagement";
        } else {
            return "login";
        }
    }
    @ResponseBody
    @RequestMapping(value = "/findbasedata/{type}",method = RequestMethod.GET)
    public JsonResult findBaseData(@PathVariable("type") int type, HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        if(type <= 0){
            type = 1;
        }else if(type > 6){
            type = 6;
        }
        List<CommonCode> codeList = baseDataService.getCommonCodesByType(CodeType.getTypeByCode(type));
        JsonResult jsonResult = new JsonResult();
        if(codeList == null || codeList.size() == 0){
            jsonResult.setStatusCode(404);
        }else {
            jsonResult.setStatusCode(200);
            Map<String,Object> params = new HashMap<String, Object>();
            params.put("codelist",codeList);
            jsonResult.setMapParams(params);
        }
        return jsonResult;
    }
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String logOut(HttpSession httpSession){
        Enumeration<?> enumeration = httpSession.getAttributeNames();
        List<String> keys = new ArrayList<String>();
        while (enumeration.hasMoreElements()){
            keys.add(enumeration.nextElement().toString());
        }
        for (String key : keys){
            httpSession.removeAttribute(key);
        }
        return "";
    }
    @RequestMapping(value = "/backManagement",method = RequestMethod.GET)
    public String backManagement(@RequestParam("level") int level,HttpSession httpSession){
        if(level == 0 && httpSession.getAttribute("alumnus") == null){
            return "not_found";
        }
        UserLevel userLevel = UserLevel.levelToUserLevel(level);
        if(userLevel == UserLevel.ADMIN_USER){
            return "admin/admin_management_index";
        }else if(userLevel == UserLevel.NORMAL_USER){
            return "userAdmin/user_management_index";
        }else {
            throw new IllegalArgumentException();
        }
    }
}
