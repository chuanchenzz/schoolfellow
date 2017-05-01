package com.chuanchen.controller;

import com.chuanchen.entity.*;
import com.chuanchen.service.BaseDataService;
import com.chuanchen.service.UserService;
import com.chuanchen.util.CommonUtil;
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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(HttpServletRequest request) {
        return "login";
    }

    @RequestMapping(value = "registry", method = RequestMethod.GET)
    public String alumnusRegistry(HttpServletRequest  request) {
        String path = request.getSession().getServletContext().getRealPath("avatars");
        System.out.print(path);
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
        return "xiaoyou_table";
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
    @RequestMapping(value = "/alumnusinfo/{id}", method = RequestMethod.GET)
    public String getAlumnusInfo(@PathVariable("id") String id,Model model) {
        JsonResult jsonResult = new JsonResult();
        Alumnus alumnus = userService.getAlumnusById(Integer.valueOf(id));
        if (alumnus == null) {
            return "xiaoyou_table";
        } else {
            model.addAttribute("alumnus",alumnus);
            return "xiaoyou_detail";
        }
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

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JsonResult userLogin(@RequestParam("user_ame") String userName, @RequestParam("password") String password) {
        password = CommonUtil.md5Password(password.trim());
        User user = userService.findUserByNameAndPassword(userName, password);
        JsonResult jsonResult = new JsonResult();
        if (user != null) {
            Alumnus alumnus = userService.getAlumnusById(user.getAlumnusId());
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("alumnus", alumnus);
            params.put("type", user.getLevel().getLevel());
            jsonResult.setMapParams(params);
            jsonResult.setStatusCode(200);
        } else {
            jsonResult.setStatusCode(404);
            jsonResult.setMessage("该用户不存在!");
        }
        return jsonResult;
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
}
