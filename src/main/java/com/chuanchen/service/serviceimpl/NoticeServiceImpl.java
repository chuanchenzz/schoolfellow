package com.chuanchen.service.serviceimpl;

import com.chuanchen.dao.NoticeMapper;
import com.chuanchen.entity.Notice;
import com.chuanchen.service.NoticeService;
import com.chuanchen.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Created by chuanchenwine on 2017/4/24.
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    private final int PAGE_SIZE = 15;

    @Autowired
    NoticeMapper noticeMapper;

    public int getPageCount() {
        int totalNoticeSize = getTotalCount();
        return totalNoticeSize % PAGE_SIZE == 0 ? totalNoticeSize / PAGE_SIZE : totalNoticeSize / PAGE_SIZE + 1;
    }

    public List<Notice> findNotices(int page, int limit) {
        int begin = (page - 1) * PAGE_SIZE;
        return noticeMapper.findNotices(begin, limit);
    }

    public List<Notice> findNoticesByType(int page, int limit, int type) {
        int begin = (page - 1) * PAGE_SIZE;
        return noticeMapper.findNoticesByType(begin,limit,type);
    }

    public int getTotalByStatus(int statusCode) {
        return noticeMapper.getNoticesCountByStatus(statusCode);
    }

    public List<Notice> findNoticesByStatus(int page, int limit, int statusCode) {
        int begin = (page - 1) * PAGE_SIZE;
        return noticeMapper.findNoticesByStatus(begin,limit,statusCode);
    }

    public boolean updateNotice(int noticeId, int status) {
        return noticeMapper.updateNotice(noticeId,status) > 0 ? true : false;
    }

    public int putNotice(Notice notice) {
        return 0;
    }

    public Notice getNoticeById(int id) {
        return noticeMapper.getNoticeById(id);
    }

    public int getTotalCount() {
        return noticeMapper.totalNoticeSize();
    }

    public boolean deleteNoticeById(int id) {
        int deleteId = noticeMapper.deleteNoticeById(id);
        return deleteId > 0 ? true : false;
    }

    public int getTotalCountByType(int type) {
        return noticeMapper.getTotalCountByType(type);
    }

    public List<Notice> getNoticesByAlumnusId(int page,int limit,int alumnusId) {
        int begin = (page - 1) * Constant.NOTICE_PAGE_COUNT;
        List<Notice> noticeList = noticeMapper.getNoticesByAlumnusId(begin,limit,alumnusId);
        return noticeList == null ? Collections.<Notice>emptyList() : noticeList;
    }

    public int getCountByAlumnusId(int alumnusId) {
        return noticeMapper.getCountByAlumnusId(alumnusId);
    }
}
