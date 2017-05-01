package com.chuanchen.controller;

import com.chuanchen.entity.JsonResult;
import com.chuanchen.entity.Notice;
import com.chuanchen.entity.NoticeType;
import com.chuanchen.entity.Status;
import com.chuanchen.service.NoticeService;
import com.chuanchen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/findNotices", method = RequestMethod.GET)
    public String findNotices(@RequestParam(value = "page", required = true) int page, @RequestParam(value = "limit", required = false, defaultValue = "10") int limit, Model model) {
        int totalCount = noticeService.getTotalCount();
        if (totalCount < 0) {
            return "notice_message_table";
        }
        int pageCount = pageCount(totalCount);
        if (page <= 0) {
            page = 1;
        } else if (page > pageCount) {
            page = pageCount;
        }
        List<Notice> notices = noticeService.findNotices(page, limit);
        model.addAttribute("notices", notices);
        model.addAttribute("totalCount",totalCount);
        return "notice_message_table";
    }

    private int pageCount(int totalCount) {
        return totalCount % DEFAULT_COUNT == 0 ? totalCount / DEFAULT_COUNT : totalCount / DEFAULT_COUNT + 1;
    }

    @ResponseBody
    @RequestMapping(value = "checknotice/{noticeId}", method = RequestMethod.GET)
    public JsonResult checkNotice(@PathVariable("noticeId") int noticeId, @RequestParam("status") int status) {
        JsonResult jsonResult = new JsonResult();
        Status statusType = Status.codeToStatus(status);
        boolean result = noticeService.updateNotice(noticeId, statusType.getStatusCode());
        if (result) {
            jsonResult.setStatusCode(200);
            jsonResult.setMessage("审核完成,审核结果:" + statusType.getDescription());
        } else {
            jsonResult.setStatusCode(404);
            jsonResult.setMessage("审核失败,请重新审核!");
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
            String userName = userService.getAlumnusNameById(userId);
            model.addAttribute("notice", notice);
            model.addAttribute("username", userName);
            return "";
        } else {
            return "";
        }
    }
    @RequestMapping(value = "/deletenotice/{id}",method = RequestMethod.GET)
    public String deleteNotice(@PathVariable("id") int id){
        boolean result = noticeService.deleteNoticeById(id);
        return "redirect:/notice/findNotices?page=1&limit=15";
    }
}
