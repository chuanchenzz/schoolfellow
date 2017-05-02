package com.chuanchen.service;

import com.chuanchen.entity.Notice;

import java.util.List;

/**
 * Created by chuanchenwine on 2017/4/24.
 */
public interface NoticeService {

    int getPageCount();

    List<Notice> findNotices(int page,int limit);

    List<Notice> findNoticesByType(int page,int limit,int type);

    int getTotalByStatus(int statusCode);

    List<Notice> findNoticesByStatus(int page,int limit,int statusCode);

    boolean updateNotice(int noticeId,int status);

    int putNotice(Notice notice);

    Notice getNoticeById(int id);

    int getTotalCount();

    boolean deleteNoticeById(int id);

    int getTotalCountByType(int type);
}
