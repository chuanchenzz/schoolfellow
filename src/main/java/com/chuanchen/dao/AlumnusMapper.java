package com.chuanchen.dao;

import com.chuanchen.entity.Alumnus;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by chuanchenwine on 2017/4/21.
 */
public interface AlumnusMapper {
    int isAlumnusExist(@Param("name") String name, @Param("studentNumber") String studentNumber);

    int saveAlumnus(Alumnus alumnus);

    Alumnus getAlumnusById(@Param("id") int id);

    int deleteAlumusById(@Param("id") int id);

    List<Alumnus> findAlumnuses(@Param("begin") int begin,@Param("limit") int limit);

    int getAlumnusCount();

    String getAlumnusNameById(@Param("id") int id);
}
