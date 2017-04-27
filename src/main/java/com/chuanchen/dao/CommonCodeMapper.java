package com.chuanchen.dao;

import com.chuanchen.entity.CommonCode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chuanchenwine on 2017/4/26.
 */
public interface CommonCodeMapper {
    List<CommonCode> getCommonCodesByType(@Param("type") int type);
}
