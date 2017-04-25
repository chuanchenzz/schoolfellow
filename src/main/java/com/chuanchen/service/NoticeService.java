package com.chuanchen.service;

import com.chuanchen.entity.Notice;

import java.util.List;

/**
 * Created by chuanchenwine on 2017/4/24.
 */
public interface NoticeService {

    int getPageCount();

    List<Notice> findNotices(int page,int limit);

    int getTotalByStatus(int statusCode);

    List<Notice> findNoticesByStatus(int page,int limit,int statusCode);

    boolean updateNotice(int noticeId,int status);

    int putNotice(Notice notice);
}
