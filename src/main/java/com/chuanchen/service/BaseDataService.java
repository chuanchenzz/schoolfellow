package com.chuanchen.service;

import com.chuanchen.entity.CodeType;
import com.chuanchen.entity.CommonCode;

import java.util.List;

/**
 * Created by chuanchenwine on 2017/4/26.
 */
public interface BaseDataService {
    List<CommonCode> getCommonCodesByType(CodeType type);

    CommonCode getCommonCodeFromCacheById(int type,int id);

    CommonCode getCommonCodeFromCacheByName(int type,String name);

    CommonCode getCommonCodeById(int type,int id);

    CommonCode getCommonCodeByName(int type,String name);
}
