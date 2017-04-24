package com.chuanchen.controller;

import com.chuanchen.entity.JsonResult;
import com.chuanchen.entity.Notice;
import com.chuanchen.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
}
