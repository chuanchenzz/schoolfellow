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
}
