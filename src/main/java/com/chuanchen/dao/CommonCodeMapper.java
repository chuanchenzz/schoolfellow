package com.chuanchen.dao;

import com.chuanchen.entity.CommonCode;

import java.util.List;

/**
 * Created by chuanchenwine on 2017/4/26.
 */
public interface CommonCodeMapper {
    List<CommonCode> getCommonCodesByType(int type);
}
