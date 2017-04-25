package com.chuanchen.service.serviceimpl;

import com.chuanchen.dao.NoticeMapper;
import com.chuanchen.entity.Notice;
import com.chuanchen.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chuanchenwine on 2017/4/24.
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    private final int PAGE_SIZE = 10;

    @Autowired
    NoticeMapper noticeMapper;

    public int getPageCount() {
        int totalNoticeSize = noticeMapper.totalNoticeSize();
        return totalNoticeSize % PAGE_SIZE == 0 ? totalNoticeSize / PAGE_SIZE : totalNoticeSize / PAGE_SIZE + 1;
    }

    public List<Notice> findNotices(int page, int limit) {
        int begin = (page - 1) * PAGE_SIZE;
        return noticeMapper.findNotices(begin, limit);
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
}
