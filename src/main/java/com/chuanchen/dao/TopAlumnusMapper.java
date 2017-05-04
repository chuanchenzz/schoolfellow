package com.chuanchen.dao;

import com.chuanchen.entity.TopAlumnus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chuanchenwine on 2017/5/2.
 */
public interface TopAlumnusMapper {

    int uploadTopAlumnus(TopAlumnus topAlumnus);

    List<TopAlumnus> findTopAlumnus(@Param("begin") int begin,@Param("limit") int limit);

    int getTotalCount();
}
