package com.chuanchen.dao;

import com.chuanchen.entity.Alumnus;
import com.chuanchen.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * Created by chuanchenwine on 2017/4/20.
 */
public interface UserMapper {
    int isAlumnusExist(@Param("name") String name, @Param("studentNumber") String studentNumber, @Param("startAge")Date startAge);

    int isUserExist(@Param("userName") String userName);

    int saveAlumnus(Alumnus alumnus);

    int saveUser(User user);

}
