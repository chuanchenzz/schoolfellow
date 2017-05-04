package com.chuanchen.service.serviceimpl;

import com.chuanchen.dao.TopAlumnusMapper;
import com.chuanchen.entity.TopAlumnus;
import com.chuanchen.service.TopAlumnusService;
import com.chuanchen.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chuanchenwine on 2017/5/2.
 */
@Service
public class TopAlumnusServiceImpl implements TopAlumnusService{
    @Autowired
    TopAlumnusMapper topAlumnusMapper;

    public boolean uploadTopAlumnus(TopAlumnus topAlumnus) {
        int insertId = topAlumnusMapper.uploadTopAlumnus(topAlumnus);
        return insertId > 0 ? true : false;
    }

    public List<TopAlumnus> findTopAlumnus(int page, int limit) {
        int begin = (page - 1) * Constant.TOPALUMNUS_PAGE_COUNT;
        return topAlumnusMapper.findTopAlumnus(begin,limit);
    }

    public int getTotalCount() {
        return topAlumnusMapper.getTotalCount();
    }
}
