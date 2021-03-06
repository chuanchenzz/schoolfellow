package com.chuanchen.controller;

import com.chuanchen.entity.*;
import com.chuanchen.service.NoticeService;
import com.chuanchen.service.UserService;
import com.chuanchen.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chuanchenwine on 2017/4/24.
 */
@Controller
@RequestMapping("/notice")
@SessionAttributes("")
public class NoticeController {
    @Autowired
    NoticeService noticeService;
    @Autowired
    UserService userService;
    private final int DEFAULT_COUNT = 15;

    @RequestMapping(value = "/findNotices/{type}", method = RequestMethod.GET)
    public String findNotices(@PathVariable("type") int type, @RequestParam(value = "page", required = true) int page, @RequestParam(value = "limit", required = false, defaultValue = "15") int limit, Model model) {
        NoticeType noticeType = NoticeType.codeToType(type);
        int totalCount = noticeService.getTotalCountByType(noticeType.getType());
        if (totalCount < 0) {
            return toPageByType(noticeType);
        }
        int pageCount = pageCount(totalCount);
        if (page <= 0) {
            page = 1;
        } else if (page > pageCount) {
            page = pageCount;
        }
        List<Notice> notices = noticeService.findNoticesByType(page,limit,noticeType.getType());
        model.addAttribute("notices", notices);
        model.addAttribute("totalCount", totalCount);
        return toPageByType(noticeType);
    }

    private String toPageByType(NoticeType noticeType) {
        switch (noticeType) {
            case NOTICE_MESSAGE:
                return "admin/notice_message_table";
            case SCHOOL_DYNAMIC:
                return "admin/campus_message_table";
            case ALUMNUS_MESSAGE:
                return "admin/xiaoyou_message_table";
            default:
                return "admin/notice_message_table";
        }
    }

    private int pageCount(int totalCount) {
        if(totalCount / DEFAULT_COUNT == 0){
            return 1;
        }
        return totalCount % DEFAULT_COUNT == 0 ? totalCount / DEFAULT_COUNT : totalCount / DEFAULT_COUNT + 1;
    }

    @ResponseBody
    @RequestMapping(value = "/checknotice", method = RequestMethod.POST)
    public JsonResult checkNotice(@RequestParam("noticeId") int noticeId, @RequestParam("status") int status) {
        JsonResult jsonResult = new JsonResult();
        Status statusType = Status.codeToStatus(status);
        boolean result = noticeService.updateNotice(noticeId, statusType.getStatusCode());
        if (result) {
            jsonResult.setStatusCode(200);
        } else {
            jsonResult.setStatusCode(404);
        }
        return jsonResult;
    }

    @ResponseBody
    @RequestMapping(value = "/putNotice", method = RequestMethod.POST)
    public JsonResult putNotice(@RequestParam("notice_type") String noticeType, @RequestParam("title") String title, @RequestParam("content") String content, @RequestParam("user_id") int userId) {
        JsonResult jsonResult = new JsonResult();
        Notice notice = new Notice();
        notice.setPubDate(new Date());
        notice.setType(NoticeType.desToType(noticeType));
        notice.setTitle(title);
        notice.setUserId(userId);
        notice.setContent(content);
        notice.setStatus(Status.NOT_AUDIT);
        if (noticeService.putNotice(notice) > 0) {
            jsonResult.setStatusCode(200);
        } else {
            jsonResult.setStatusCode(500);
        }
        return jsonResult;
    }

    @RequestMapping(value = "/noticeinfo/{id}", method = RequestMethod.GET)
    public String findNoticeInfo(@PathVariable("id") int noticeId, Model model) {
        Notice notice = noticeService.getNoticeById(noticeId);
        if (notice != null) {
            int userId = notice.getUserId();
            String userName = userService.getUsernameById(userId);
            model.addAttribute("notice", notice);
            model.addAttribute("username", userName);
            return "admin/notice_info";
        } else {
            return "admin/notice_info";
        }
    }
    //user
    @RequestMapping(value = "/userPulishNoticePage",method = RequestMethod.GET)
    public String publishNoticePage(Model model,HttpSession httpSession){
        Alumnus alumnus = (Alumnus) httpSession.getAttribute("alumnus");
        if(alumnus == null){
            return "请重新登陆!";
        }
        model.addAttribute("alumnusId",alumnus.getId());
        return "userAdmin/user_publish_notice";
    }
    @RequestMapping(value = "/deletenotice/{id}", method = RequestMethod.GET)
    public String deleteNotice(@PathVariable("id") int id) {
        boolean result = noticeService.deleteNoticeById(id);
        return "redirect:/notice/findNotices?page=1&limit=15";
    }
    //user
    @RequestMapping(value = "/myPublishNotice",method = RequestMethod.GET)
    public String checkMyPublishNotice(@RequestParam("page") int page,@RequestParam("limit") int limit, Model model, HttpSession httpSession){
        Alumnus alumnus = (Alumnus) httpSession.getAttribute("alumnus");
        if(alumnus == null){
            return "请重新登陆!";
        }
        int count = noticeService.getCountByAlumnusId(alumnus.getId());
        int pageCount = pageCount(count);
        if(page <= 0 ){
            page = 1;
        }
        if(page > pageCount){
            page = pageCount;
        }
        if(limit != Constant.NOTICE_PAGE_COUNT){
            limit = Constant.NOTICE_PAGE_COUNT;
        }
        List<Notice> noticeList = noticeService.getNoticesByAlumnusId(page,limit,alumnus.getId());
        model.addAttribute("noticeList",noticeList);
        model.addAttribute("count",count);
        model.addAttribute("pageCount",pageCount);
        return "userAdmin/user_publish_notice_table";
    }

}
