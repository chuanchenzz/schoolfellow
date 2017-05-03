package com.chuanchen.service.serviceimpl;

import com.chuanchen.dao.TopAlumnusMapper;
import com.chuanchen.entity.TopAlumnus;
import com.chuanchen.service.TopAlumnusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
