package com.chuanchen.service;

import com.chuanchen.entity.CommonCode;

import java.util.List;

/**
 * Created by chuanchenwine on 2017/4/26.
 */
public interface BaseDataService {
    List<CommonCode> getCommonCodesByType(int type);
}