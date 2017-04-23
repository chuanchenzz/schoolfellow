package com.chuanchen.dao;

import com.chuanchen.entity.Alumnus;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * Created by chuanchenwine on 2017/4/21.
 */
public interface AlumnusMapper {
    int isAlumnusExist(@Param("name") String name, @Param("studentNumber") String studentNumber, @Param("startAge")Date startAge);

    int saveAlumnus(Alumnus alumnus);

    Alumnus getAlumnusById(int id);

    int deleteAlumusById(int id);
}
