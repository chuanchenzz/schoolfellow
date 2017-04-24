package com.chuanchen.service;

import com.chuanchen.entity.Notice;

import java.util.List;

/**
 * Created by chuanchenwine on 2017/4/24.
 */
public interface NoticeService {

    int getPageCount();

    List<Notice> findNotices(int page,int limit);

}
