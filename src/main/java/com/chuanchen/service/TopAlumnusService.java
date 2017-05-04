package com.chuanchen.service;

import com.chuanchen.entity.TopAlumnus;

import java.util.List;

/**
 * Created by chuanchenwine on 2017/5/2.
 */
public interface TopAlumnusService {

    boolean uploadTopAlumnus(TopAlumnus topAlumnus);

    List<TopAlumnus> findTopAlumnus(int page,int limit);

    int getTotalCount();
}
