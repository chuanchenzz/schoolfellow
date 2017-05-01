package com.chuanchen.dao;

import com.chuanchen.entity.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chuanchenwine on 2017/4/24.
 */
public interface NoticeMapper {
    int totalNoticeSize();

    List<Notice> findNotices(@Param("begin") int begin, @Param("limit") int limit);

    int getNoticesCountByStatus(@Param("status") int statusCode);

    List<Notice> findNoticesByStatus(@Param("begin") int begin,@Param("limit") int limit,@Param("status") int statusCode);

    int updateNotice(@Param("noticeId") int noticeId,@Param("status") int status);

    int putNotice(Notice notice);

    Notice getNoticeById(@Param("id") int id);

    int deleteNoticeById(@Param("id") int id);
}
