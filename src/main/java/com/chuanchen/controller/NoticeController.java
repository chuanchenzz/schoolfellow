package com.chuanchen.controller;

import com.chuanchen.entity.JsonResult;
import com.chuanchen.entity.Notice;
import com.chuanchen.entity.NoticeType;
import com.chuanchen.entity.Status;
import com.chuanchen.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    @ResponseBody
    @RequestMapping(value = "findNotices",method = RequestMethod.GET)
    public JsonResult findNotices(@RequestParam(value = "page",required = true) int page,@RequestParam(value = "limit",required = false,defaultValue = "10") int limit){
        JsonResult jsonResult = new JsonResult();
        int pageCount = noticeService.getPageCount();
        if(pageCount <= 0){
            jsonResult.setStatusCode(404);
            jsonResult.setMessage("can't find notices!");
            return jsonResult;
        }
        if(page <= 0 ){
            page = 1;
        }else if(page > pageCount){
            page = pageCount;
        }
        List<Notice> notices = noticeService.findNotices(page,limit);
        jsonResult.setStatusCode(200);
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("notices",notices);
        jsonResult.setMapParams(params);
        return jsonResult;
    }
    @ResponseBody
    @RequestMapping(value = "checknotice/{noticeId}",method = RequestMethod.GET)
    public JsonResult checkNotice(@PathVariable("noticeId") int noticeId,@RequestParam("status") int status){
        JsonResult jsonResult = new JsonResult();
        Status statusType = Status.codeToStatus(status);
        boolean result = noticeService.updateNotice(noticeId,statusType.getStatusCode());
        if(result){
            jsonResult.setStatusCode(200);
            jsonResult.setMessage("审核完成,审核结果:"+statusType.getDescription());
        }else{
            jsonResult.setStatusCode(404);
            jsonResult.setMessage("审核失败,请重新审核!");
        }
        return jsonResult;
    }
    @ResponseBody
    @RequestMapping(value = "/putNotice",method = RequestMethod.POST)
    public JsonResult putNotice(@RequestParam("notice_type") String noticeType,@RequestParam("title") String title,@RequestParam("content") String content,@RequestParam("user_id") int userId){
        JsonResult jsonResult = new JsonResult();
        Notice notice = new Notice();
        notice.setPubDate(new Date());
        notice.setType(NoticeType.desToType(noticeType));
        notice.setTitle(title);
        notice.setUserId(userId);
        notice.setContent(content);
        notice.setStatus(Status.NOT_AUDIT);
        if(noticeService.putNotice(notice) > 0){
            jsonResult.setStatusCode(200);
        }else {
            jsonResult.setStatusCode(500);
        }
        return jsonResult;
    }
}
