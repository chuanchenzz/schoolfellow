package com.chuanchen.controller;

import com.chuanchen.entity.Alumnus;
import com.chuanchen.entity.JsonResult;
import com.chuanchen.entity.Sex;
import com.chuanchen.entity.User;
import com.chuanchen.service.UserService;
import com.chuanchen.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chuanchen-pc on 2017/3/11.
 */
@Controller
@RequestMapping("/user")
@SessionAttributes(value = {"user"})
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String toTestPage() {
        return "test";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(HttpServletRequest request) {
        return "login";
    }

    @RequestMapping(value = "registry", method = RequestMethod.GET)
    public String alumnusRegistry() {
        Date date = new Date();
        System.out.println(date);
        return "xiaoyou_registry";
    }

    @ResponseBody
    @RequestMapping(value = "/checkaccount", method = RequestMethod.POST)
    public JsonResult checkAccount(@RequestParam(value = "name", required = true) String name, @RequestParam(value = "student_number") String studentNumber, @RequestParam(value = "start_age") String entryAge, Model model, HttpSession session) {
        if (session.getAttribute("user") != null) {
            session.removeAttribute("user");
        }
        Date date = CommonUtil.strToDate(entryAge);
        JsonResult jsonResult = new JsonResult();
//        if(userService.isAlumnusExist(name,studentNumber,date)){
//            jsonResult.setStatusCode(500);
//            jsonResult.setMessage("该用户已经存在,请不要重复注册!");
//        }else {
//            jsonResult.setStatusCode(200);
//        }
        jsonResult.setStatusCode(200);
        return jsonResult;
    }
    @RequestMapping(value = "/findUsers",method = RequestMethod.GET)
    public JsonResult findUsers(@RequestParam(value = "page",required = true) int page,@RequestParam(value = "limit",required = false,defaultValue = "10") int limit){
        JsonResult jsonResult = new JsonResult();
        int totalPage = userService.getTotalPage();
        if(page <= 0){
            page = 1;
        }
        if(page > totalPage){
            page = totalPage;
        }
        List<Alumnus> alumnusList = userService.findAlumnuses(page,limit);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("alumnusList",alumnusList);
        jsonResult.setMapParams(map);
        jsonResult.setStatusCode(200);
        return jsonResult;
    }
    @ResponseBody
    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public JsonResult addUser(@RequestParam(value = "userName", required = true) String userName, @RequestParam(value = "password", required = true) String password, Model model) {
        JsonResult jsonResult = new JsonResult();
//        if (userService.isUserExist(userName)) {
//            jsonResult.setStatusCode(500);
//            jsonResult.setMessage("该用户名已经存在,请修改用户名!");
//        } else {
//            User user = new User();
//            user.setUserName(userName);
//            user.setPassword(password);
//            model.addAttribute("user", user);
//            jsonResult.setStatusCode(200);
//        }
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        model.addAttribute("user", user);
        jsonResult.setStatusCode(200);
        return jsonResult;
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public JsonResult register(@RequestParam("name") String name, @RequestParam("sex") String sex, @RequestParam("nation") String nation,
                               @RequestParam("identity") String identity, @RequestParam("idCard") String idCard, @RequestParam("birthday") String birthday,
                               @RequestParam("birthPlace") String birthPlace, @RequestParam("address") String address, @RequestParam("phone") String phone,
                               @RequestParam("email") String email, @RequestParam("education") String education, @RequestParam("entranceAge") String entranceAge,
                               @RequestParam("graduteAge") String graduteAge, @RequestParam("academic") String academic, @RequestParam("profession") String profession,
                               @RequestParam("classs") String classs, @RequestParam("workAddress") String workAddress, @RequestParam("inductive") String inductive,
                               @RequestParam("organization") String organization, @RequestParam("industry") String industry, @RequestParam("organizationNature") String organizationNature,
                               @RequestParam("department") String department, @RequestParam("job") String job, HttpSession session, Model model) {
        Alumnus alumnus = new Alumnus();
        alumnus.setName(name);
        alumnus.setSex(Sex.codeToSex(Integer.valueOf(sex)));
        alumnus.setNation(nation);
        alumnus.setIdentity(identity);
        alumnus.setIdCard(idCard);
        alumnus.setBirthday(CommonUtil.isDatePattern(birthday) ? birthday : null);
        alumnus.setBirthPlace(birthPlace);
        alumnus.setAddress(address);
        alumnus.setPhone(phone);
        alumnus.setEmail(email);
        alumnus.setEducation(education);
        alumnus.setEntranceAge(CommonUtil.isDatePattern(entranceAge) ? entranceAge : null);
        alumnus.setGraduteAge(CommonUtil.isDatePattern(graduteAge) ? graduteAge : null);
        alumnus.setAcademic(academic);
        alumnus.setProfession(profession);
        alumnus.setClasss(classs);
        alumnus.setWorkAddress(workAddress);
        alumnus.setInductive(CommonUtil.isDatePattern(inductive) ? inductive : null);
        alumnus.setOrganization(organization);
        alumnus.setIndustry(industry);
        alumnus.setOrganizationNature(organizationNature);
        alumnus.setDepartment(department);
        alumnus.setJob(job);
        JsonResult jsonResult = new JsonResult();
        if (session.getAttribute("user") == null) {
            jsonResult.setStatusCode(500);
            jsonResult.setMessage("发生错误,请重新注册!");
        }
        User user = (User) session.getAttribute("user");
        if (userService.saveUserAndAlumnus(user, alumnus) > 0) {
            jsonResult.setStatusCode(200);
            jsonResult.setMessage("用户注册成功!");
        } else {
            jsonResult.setStatusCode(500);
            jsonResult.setMessage("用户注册失败,请重新注册!");
        }
        return jsonResult;
    }

    @ResponseBody
    @RequestMapping(value = "/alumnusinfo/{id}", method = RequestMethod.GET)
    public JsonResult getAlumnusInfo(@PathVariable("id") String id) {
        JsonResult jsonResult = new JsonResult();
        Alumnus alumnus = userService.getAlumnusById(Integer.valueOf(id));
        if (alumnus == null) {
            jsonResult.setStatusCode(404);
            jsonResult.setMessage("没有找到该用户的信息!");
        } else {
            jsonResult.setStatusCode(200);
        }
        return jsonResult;
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
}
